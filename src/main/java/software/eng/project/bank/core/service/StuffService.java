package software.eng.project.bank.core.service;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.eng.project.bank.core.Exception.BadArgumentException;
import software.eng.project.bank.core.Exception.ServerErrorException;
import software.eng.project.bank.core.boundry.request.CheckPassRequest;
import software.eng.project.bank.core.boundry.request.CreateAccountRequest;
import software.eng.project.bank.core.boundry.request.CreateDraftRequest;
import software.eng.project.bank.core.boundry.request.CreateResponseRequest;
import software.eng.project.bank.core.boundry.response.Response;
import software.eng.project.bank.core.boundry.response.ResponseStatus;
import software.eng.project.bank.core.model.Account.*;
import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Request.*;
import software.eng.project.bank.core.model.Response.RequestResponse;

import software.eng.project.bank.core.model.Role.Stuff;
import software.eng.project.bank.core.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuffService {
    @Autowired
    CheckRepository checkRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    UserService userService;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    StuffRepository stuffRepository;

    @Autowired
    AccessCardRequestRepository accessCardRequestRepository;

    @Autowired
    CheckBookRequestRepository checkBookRequestRepository;

    @Autowired
    FacilityRequestRepository facilityRequestRepository;



    public List<Request> getRequests(long stuffID){
        List<Request> requests = new ArrayList<>();
        requests.addAll(this.checkBookRequestRepository.findByStuff_Id(stuffID));
        requests.addAll(this.facilityRequestRepository.findByStuff_Id(stuffID));
        requests.addAll(this.accessCardRequestRepository.findByStuff_Id(stuffID));
        return requests;
    }
    public Request getRequest(long requestID) throws BadArgumentException {
        if(this.checkBookRequestRepository.exists(requestID)){
            return this.checkBookRequestRepository.findOne(requestID);
        }else if (this.accessCardRequestRepository.exists(requestID)){
            return this.accessCardRequestRepository.findOne(requestID);
        }else if(this.facilityRequestRepository.exists(requestID)){
            return this.facilityRequestRepository.findOne(requestID);
        }else {
            throw new BadArgumentException();
        }
    }
    public Response answerRequest(CreateResponseRequest createResponseRequest, long stuffID) throws BadArgumentException, ServerErrorException {
        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setAccept(createResponseRequest.isAccept());
        requestResponse.setForWhy(createResponseRequest.getForWhy());
        requestResponse.setDayRequiredForReady(createResponseRequest.getDayForReady());
        Response response =new Response();
        try {
            if (!this.stuffRepository.exists(stuffID)) {
                throw new BadArgumentException();
            }
            Request request = this.getRequest(createResponseRequest.getRequestID());
            if(request.getStuff().getId().equals(stuffID)){ // stuff marboote bayad pasokh bedahad
                throw new BadArgumentException();
            }
            if(createResponseRequest.isAccept()){
                request.setStatus(RequestStatus.ACCEPT);
            } else if (!createResponseRequest.isAccept()){
                request.setStatus(RequestStatus.REJECT);
            } else {
                request.setStatus(RequestStatus.READED);
            }
            if (request instanceof CheckBookRequest) {
                request.setRequestResponse(requestResponse);
                this.checkBookRequestRepository.save((CheckBookRequest) request);
            } else if (request instanceof AccessCardRequest) {
                request.setRequestResponse(requestResponse);
                this.accessCardRequestRepository.save((AccessCardRequest) request);
            } else if (request instanceof FacilityRequest) {
                request.setRequestResponse(requestResponse);
                this.facilityRequestRepository.save((FacilityRequest) request);
            }
            response.setFallowUpNumber(0);
            response.setResponseStatus(ResponseStatus.OK);
        }catch (Exception e ){
            e.printStackTrace();
            response.setResponseStatus(ResponseStatus.ERROR);
            throw new ServerErrorException();
        }finally {
            return response;
        }
    }
    public Response redirectRequest(long requestID, long userID) throws BadArgumentException {
        Request request = this.getRequest(requestID);
        request.setStuff(this.stuffRepository.findOne(userID));
        Response response = new Response();
        try {
            request.setStatus(RequestStatus.REDIRECTED);
            if (request instanceof CheckBookRequest) {
                this.checkBookRequestRepository.save((CheckBookRequest) request);
            } else if (request instanceof AccessCardRequest) {
                this.accessCardRequestRepository.save((AccessCardRequest) request);
            } else if (request instanceof FacilityRequest) {
                this.facilityRequestRepository.save((FacilityRequest) request);
            }
            response.setResponseStatus(ResponseStatus.OK);
        }catch (Exception e ){
            e.printStackTrace();
            response.setResponseStatus(ResponseStatus.ERROR);
            throw new ServerErrorException();
        }finally {
            return response;
        }

    }
    public Response createAccount(CreateAccountRequest createAccountRequest , long stuffID) throws BadArgumentException { //TODO SHOULD SAVE STUFF WHO CREATE ACCOUNT
        Account account =this.accountRepository.findByAccountNumber(createAccountRequest.getAccountNumberForInit());
        Account account1= new Account();
        Response response =new Response();
        Stuff stuff =this.stuffRepository.findByUser_Id(stuffID);
        if(account.getCustomer().getNationalCode().equals(createAccountRequest.getNationalCodeCustomer())){
            if(this.branchRepository.findOne(stuff.getBranch().getId())==null){
                throw new BadArgumentException();
            }else{
                if(createAccountRequest.getAccountType()== AccountType.GHARZ || createAccountRequest.getAccountType()==AccountType.JARI || createAccountRequest.getAccountType()==AccountType.SEPORDE_KOTAH){
                    account1= new Account();
                    account1.setAccountStatus(new AccountStatus(AccountStatusType.OPEN, null , null , null));
                    account1.setCustomer(this.customerRepository.findByNationalCode(createAccountRequest.getNationalCodeCustomer()));
                    account1.setAccountType(createAccountRequest.getAccountType());
                    account1.setAccountTypeIndivisual(createAccountRequest.getAccountTypeIndivisual());
                    account1.setAccountTypeReal(createAccountRequest.getAccountTypeReal());
                    account1=this.accountRepository.save(account1);
                    userService.createDraft(new CreateDraftRequest(createAccountRequest.getInitCash(),account.getAccountNumber(),account1.getAccountNumber(),null, null ),
                            this.customerRepository.findByNationalCode(createAccountRequest.getNationalCodeCustomer()).getId());
                    response.setResponseStatus(ResponseStatus.OK);
                }else {response.setResponseStatus(ResponseStatus.ERROR);throw new BadArgumentException();}
            }
        }else{response.setResponseStatus(ResponseStatus.ERROR);throw new BadArgumentException();}
        return response;
    }
    public Response passCheck(CheckPassRequest checkPassRequest) throws BadArgumentException {
        Preconditions.checkNotNull(checkPassRequest.getCash());
        Preconditions.checkNotNull(checkPassRequest.getCheckNumber());
        Preconditions.checkNotNull(checkPassRequest.getToName());

        Response response =new Response();
        CheckID checkID1= new CheckID();
        checkID1.setCheckNumber(checkPassRequest.getCheckNumber());
        checkID1.setCheckBookNumber(checkPassRequest.getCheckBookNumber());
        Check check = this.checkRepository.getOne(checkID1);
        check.setToName(checkPassRequest.getToName());
        check.setCash(checkPassRequest.getCash());
        if(check.getStatus()== CheckStatusType.PASS){
            throw new BadArgumentException();
        }
        else {
            if(check.getCheckBook().getAccount().getCash()>check.getCash()){
                //TODO IS IMPORT IN DRAFT
                check.setStatus(CheckStatusType.PASS);
                this.checkRepository.delete(check.getCheckID());
                this.checkRepository.save(check);
                this.accountRepository.updateCashValue(check.getCheckBook().getAccount().getCash()-check.getCash() ,
                        check.getCheckBook().getAccount().getId() );
                response.setResponseStatus(ResponseStatus.OK);
            }else{
                check.setStatus(CheckStatusType.REJECTED);
                this.checkRepository.delete(check.getCheckID());
                this.checkRepository.save(check);
                response.setResponseStatus(ResponseStatus.ERROR);
            }
        }
        return response;
    }
    public List<Stuff> getStuffList(long stuffID){
        Branch branch=this.stuffRepository.findByUser_Id(stuffID).getBranch();
        return this.stuffRepository.findByBranch_Id(branch.getId());
    }

}
