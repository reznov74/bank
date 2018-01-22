package software.eng.project.bank.core.service;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.eng.project.bank.core.Exception.BadArgumentException;
import software.eng.project.bank.core.Exception.ServerErrorException;
import software.eng.project.bank.core.boundry.request.CheckPassRequest;
import software.eng.project.bank.core.boundry.request.CreateAccountRequest;
import software.eng.project.bank.core.boundry.request.CreateResponseRequest;
import software.eng.project.bank.core.boundry.response.Response;
import software.eng.project.bank.core.boundry.response.ResponseStatus;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Account.Check;
import software.eng.project.bank.core.model.Account.CheckID;
import software.eng.project.bank.core.model.Account.CheckStatusType;
import software.eng.project.bank.core.model.Request.AccessCardRequest;
import software.eng.project.bank.core.model.Request.CheckBookRequest;
import software.eng.project.bank.core.model.Request.FacilityRequest;
import software.eng.project.bank.core.model.Request.Request;
import software.eng.project.bank.core.model.Response.RequestResponse;

import software.eng.project.bank.core.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuffService {
    @Autowired
    CheckRepository checkRepository;
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
            return this.checkBookRequestRepository.getOne(requestID);
        }else if (this.accessCardRequestRepository.exists(requestID)){
            return this.accessCardRequestRepository.getOne(requestID);
        }else if(this.facilityRequestRepository.exists(requestID)){
            return this.facilityRequestRepository.getOne(requestID);
        }else {
            throw new BadArgumentException();
        }
    }
    public Response answerRequest(CreateResponseRequest createResponseRequest, long stuffID) throws BadArgumentException, ServerErrorException {
        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setAccept(createResponseRequest.isAccept());
        requestResponse.setForWhy(createResponseRequest.getForWhy());
        Response response =new Response();
        try {
            if (this.stuffRepository.exists(stuffID)) {
                requestResponse.setStuff(this.stuffRepository.getOne(stuffID));
            } else {
                throw new BadArgumentException();
            }
            Request request = this.getRequest(createResponseRequest.getRequestID());
            if (request instanceof CheckBookRequest) {
                this.checkBookRequestRepository.delete(request.getId());
                request.setRequestResponse(requestResponse);
                this.checkBookRequestRepository.save((CheckBookRequest) request);
            } else if (request instanceof AccessCardRequest) {

                this.accessCardRequestRepository.delete(request.getId());
                request.setRequestResponse(requestResponse);
                this.accessCardRequestRepository.save((AccessCardRequest) request);
            } else if (request instanceof FacilityRequest) {
                this.facilityRequestRepository.delete(request.getId());
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
        request.setStuff(this.stuffRepository.getOne(userID));
        Response response = new Response();
        try {
            if (request instanceof CheckBookRequest) {
                this.checkBookRequestRepository.delete(request.getId());
                request.setStuff(this.stuffRepository.getOne(userID));
                this.checkBookRequestRepository.save((CheckBookRequest) request);
            } else if (request instanceof AccessCardRequest) {

                this.accessCardRequestRepository.delete(request.getId());
                request.setStuff(this.stuffRepository.getOne(userID));
                this.accessCardRequestRepository.save((AccessCardRequest) request);
            } else if (request instanceof FacilityRequest) {
                this.facilityRequestRepository.delete(request.getId());
                request.setStuff(this.stuffRepository.getOne(userID));
                this.facilityRequestRepository.save((FacilityRequest) request);
            }
        }catch (Exception e ){
            e.printStackTrace();
            response.setResponseStatus(ResponseStatus.ERROR);
            throw new ServerErrorException();
        }finally {
            return response;
        }

    }
    public Response createAccount(CreateAccountRequest createAccountRequest) throws BadArgumentException { //TODO SHOULD SAVE STUFF WHO CREATE ACCOUNT
        Response response =new Response();
        if(this.customerRepository.exists(createAccountRequest.getUserID())){
            try {
                Account account=this.userService.createAccount(createAccountRequest, createAccountRequest.getUserID());
                //account.setCreateStuff(); TODO
                response.setFallowUpNumber(0);
                response.setResponseStatus(ResponseStatus.OK);
            }catch (Exception e ){
                response.setResponseStatus(ResponseStatus.OK);
            }finally {
                return response;
            }
        }else{
            throw new BadArgumentException();
        }
    }
    public Response passCheck(CheckPassRequest checkPassRequest) throws BadArgumentException {
        Preconditions.checkNotNull(checkPassRequest.getCash());
        Preconditions.checkNotNull(checkPassRequest.getCheckID());
        Preconditions.checkNotNull(checkPassRequest.getToName());

        Response response =new Response();
        CheckID checkID1= new CheckID();
        checkID1.setCheckNumber(checkPassRequest.getCheckID());
        checkID1.setCheckBookNumber(checkPassRequest.getCheckBookID());
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

}
