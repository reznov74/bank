package software.eng.project.bank.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import software.eng.project.bank.core.Exception.BadArgumentException;
import software.eng.project.bank.core.Exception.UserNotFoundException;
import software.eng.project.bank.core.boundry.request.*;
import software.eng.project.bank.core.boundry.response.*;
import software.eng.project.bank.core.model.Account.*;
import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Request.AccessCardRequest;
import software.eng.project.bank.core.model.Request.CheckBookRequest;
import software.eng.project.bank.core.model.Request.FacilityRequest;
import software.eng.project.bank.core.model.Request.Request;
import software.eng.project.bank.core.model.Role.Stuff;
import software.eng.project.bank.core.repository.*;
import software.eng.project.bank.security.JwtTokenUtil;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private static double MAX_AMOUNT = 1000000000;
    private static int BUSY_STUFF = 2;

    private static int PORIFT_RATE_SHORT_TIME_ACCOUNT=7;

    private static int PORIFT_RATE_LONG_TIME_ACCOUNT=20;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountFlowRepository accountFlowRepository;

    @Autowired
    private CheckBookRepository checkBookRepository;

    @Autowired
    private DraftRepository draftRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StuffRepository stuffRepository;

    @Autowired
    private CheckBookRequestRepository checkBookRequestRepository;

    @Autowired
    private AccessCardRequestRepository accessCardRequestRepository;

    @Autowired
    private FacilityRequestRepository facilityRequestRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private FacilityReturnRepository facilityReturnRepository;

    public List<Account> getAccountList (long userID) throws UserNotFoundException {
        List<Account> queryResult = this.accountRepository.findByCustomer_IdAndAccountStatus_StatusType(userID,AccountStatusType.OPEN);
        return queryResult;
    }
    public List<AccountFlowResponse> getAccountFlow(AccountFlowRequest accountFlowRequest , long userID) throws BadArgumentException{
       //TODO account flow + draft -->>> result of this method
        List<AccountFlowResponse> responses=new ArrayList<>();
        if(accountFlowRequest.isAllActivity()){
            responses.addAll(this.getAccountFlow(accountFlowRequest,true));
            responses.addAll(this.getDraft(accountFlowRequest));
            return responses;
        }else{
            if(accountFlowRequest.getAccountFlowType().equals(AccountFlowType.HAVALE_BARDASHT) ||
                    accountFlowRequest.getAccountFlowType().equals(AccountFlowType.HAVALE_VARIZ) ){
                    return this.getDraft(accountFlowRequest);
            }else {
                return this.getAccountFlow(accountFlowRequest ,false);
            }
        }

    }
    public ResponseEntity<InputStreamResource> getReceiveAccountFlow(){
        return null;
    }
    public Response payBill(PayBillRequest payBillRequest){
        return null;
    }
    public Draft createDraft(CreateDraftRequest createDraftRequest) throws BadArgumentException {
        Account source =this.accountRepository.getOne(createDraftRequest.getSourceAccount());
        Account dist =this.accountRepository.getOne(createDraftRequest.getDistAccount());
        Draft draft =new Draft();
        if(!dist.getCustomer().getId()
                .equals(source.getCustomer().getId())){
            if(createDraftRequest.getAmount()>MAX_AMOUNT){
                throw new BadArgumentException();
            }
        }
        if(source.getCash()>createDraftRequest.getAmount()){
            source.setCash(source.getCash()-createDraftRequest.getAmount());
            dist.setCash(dist.getCash()+createDraftRequest.getAmount());
            this.accountRepository.updateCashValue(dist.getCash(),dist.getId());
            this.accountRepository.updateCashValue(source.getCash(),source.getId());
            draft =new Draft();
            draft.setAmount(createDraftRequest.getAmount());
            draft.setDistAccount(this.accountRepository.findOne(createDraftRequest.getDistAccount()));
            draft.setDraftType(DraftType.INTERNET);
            draft.setFowWhy(createDraftRequest.getForWhy());
            draft= this.draftRepository.save(draft);
        }
        return draft;
    }
    public List<Draft> reportDraftRequest(ReportDraftRequest reportDraftRequest){
        List<Draft> resultQuery = this.draftRepository.findAll();
        List<Draft> ans=new ArrayList<>();
        for(Draft draft:resultQuery){
            if(draft.getSourceAccount().getId().equals(reportDraftRequest.getAcount())){
                ans.add(draft);
            }
        }
        return ans;
    }
    public RegularDraft createRegularDraft(CreateRegularDraftRequest reportDraftRequest){
        return null;
    }
    public List<RegularDraft> reportRegularDraft(ReportDraftRequest reportDraftRequest){
        return null;
    }
    public List<GroupDraft> reportGroupDraft(ReportDraftRequest reportDraftRequest){
        return null;
    }
    public List<GroupDraft> getRequestedGroupDraft(){//need intermediate class between customer and GroupDraft for determine accepted or not
        return null;
    }
    public GroupDraft createGroupDraft(CreateGroupDraftRequest createGroupDraftRequest){
        return null;
    }
    public Response acceptGroupDraft(long draftID){
        return null;
    }
    public Account getAccountInfo(long accountID,long userID) throws BadArgumentException {
        if(this.accountRepository.getOne(accountID).getCustomer().getId().equals(userID)){
            return this.accountRepository.getOne(accountID);
        }else{
            throw new BadArgumentException();
        }
    }
    public List<CheckBook> getReportCheck(long userID){
        List<CheckBook> queryResult = this.checkBookRepository.findAll();
        List<CheckBook> ans=new ArrayList<>();
        for(CheckBook checkBook:queryResult){
            if(checkBook.getAccount().getCustomer().getId().equals(userID)){
                ans.add(checkBook);
            }
        }
        return ans;
    }
    //
    public Account createAccount(CreateAccountRequest createAccountRequest) throws BadArgumentException {
        Account account =this.accountRepository.findByAccountNumber(createAccountRequest.getAccountNumberForInit());
        Account account1= new Account();
        if(account.getCustomer().getNationalCode().equals(createAccountRequest.getNationalCodeCustomer())){
            if(this.branchRepository.findByBarnchCode(createAccountRequest.getBranchCode())==null){
                throw new BadArgumentException();
            }else{
                if(createAccountRequest.getAccountType()==AccountType.GHARZ || createAccountRequest.getAccountType()==AccountType.JARI || createAccountRequest.getAccountType()==AccountType.SEPORDE_KOTAH){
                    account1= new Account();
                    account1.setAccountStatus(new AccountStatus(AccountStatusType.OPEN, null , null , null));
                    account1.setCustomer(this.customerRepository.findByNationalCode(createAccountRequest.getNationalCodeCustomer()));
                    account1.setAccountType(createAccountRequest.getAccountType());
                    account1.setAccountTypeIndivisual(createAccountRequest.getAccountTypeIndivisual());
                    account1.setAccountTypeReal(createAccountRequest.getAccountTypeReal());
                    account1=this.accountRepository.save(account1);
                    this.createDraft(new CreateDraftRequest(createAccountRequest.getInitCash(),account.getId(),account1.getId(),null, null , true));
                }else {throw new BadArgumentException();}
            }
        }else{throw new BadArgumentException();}
        return account1;
    }
    public ReportProfitResponse reportProfitAccount(long accountID){
        return null;
    }
    public List<Account> reportBlockedAccount(Long uerID){
        List<Account> queryResult=this.accountRepository.findAll();
        List<Account> ans=new ArrayList<>();
        for(Account account:queryResult){
            if(account.getCustomer().getId().equals(uerID) || account.getAccountStatus().getStatusType()==AccountStatusType.BLOCKED){
                ans.add(account);
            }
        }
        return ans;
    }
    public Response requestCheckbook(CreateCheckbookRequest createCheckbookRequest,long userID) throws BadArgumentException {
        Response response=new Response();
        Account account =this.accountRepository.getOne(createCheckbookRequest.getAccountID());
        if(account.isWithChek()){
            for(CheckBook checkBook : account.getCheckBook()){
                Date date = new Date();
                if(!checkBook.getExpireDate().before(date)){
                    Branch branch=this.branchRepository.getOne(createCheckbookRequest.getBranchID());
                    if(branch!=null){
                        List<Stuff> stuffs= this.stuffRepository.findAll();
                        List<Stuff> activeStuff =new ArrayList<>();
                        for(Stuff stuff: stuffs){
                            if(stuff.getStuffHistory().getRank().getBranch().equals(branch)){
                                activeStuff.add(stuff);
                            }
                        }
                        for(Stuff stuff : activeStuff){
                            List<CheckBookRequest> reqs=this.checkBookRequestRepository.findByStuff_Id(stuff.getPersonalNumber());
                            if (reqs.size()<this.BUSY_STUFF){
                                CheckBookRequest checkBookRequest=new CheckBookRequest();
                                checkBookRequest.setBranch(branch);
                                checkBookRequest.setCustomer(this.customerRepository.getOne(userID));
                                checkBookRequest.setStuff(stuff);
                                response=new Response(ResponseStatus.OK,2000);
                                this.checkBookRequestRepository.save(checkBookRequest);
                                break;
                            }
                        }
                    }else{throw new BadArgumentException();}

                }else{
                    throw new BadArgumentException();
                }
            }
        }else{throw new BadArgumentException();}
        return response;
    }
    public Response requestCard(CreateCardRequest createCardRequest,long userID) throws BadArgumentException {
        Response response=new Response();
        boolean isFirstOne=true;
        Account account =this.accountRepository.getOne(createCardRequest.getAccountID());
        List<AccessCard> accessCards = account.getAccessCards();
        for(AccessCard accessCard : accessCards){
            if(accessCard.isActive()){
                isFirstOne=false;
                throw new BadArgumentException();
            }
        }
        Branch branch=this.branchRepository.getOne(createCardRequest.getBrachID());
        if(branch!=null){
            List<Stuff> stuffs= this.stuffRepository.findAll();
            List<Stuff> activeStuff =new ArrayList<>();
            for(Stuff stuff: stuffs){
                if(stuff.getStuffHistory().getRank().getBranch().equals(branch)){
                    activeStuff.add(stuff);
                }
            }
            for(Stuff stuff : activeStuff){
                List<AccessCardRequest> reqs=this.accessCardRequestRepository.findByStuff_Id(stuff.getPersonalNumber());
                if (reqs.size()<this.BUSY_STUFF){
                    AccessCardRequest accessCardRequest =new AccessCardRequest();
                    accessCardRequest.setFristOrNot(isFirstOne);
                    accessCardRequest.setBranch(branch);
                    accessCardRequest.setCustomer(this.customerRepository.getOne(userID));
                    accessCardRequest.setStuff(stuff);
                    this.accessCardRequestRepository.save(accessCardRequest);
                    response=new Response(ResponseStatus.OK,2000);
                    return response;
                }
            }

        }else{throw new BadArgumentException();}
        return response;

    }
    public Response requestFacility(CreateFacilityRequest createFacilityRequest) throws BadArgumentException {
        Response response = new Response();
        Branch branch=this.branchRepository.getOne(createFacilityRequest.getBranchID());
        if(branch!=null){
            List<Stuff> stuffs= this.stuffRepository.findAll();
            List<Stuff> activeStuff =new ArrayList<>();
            for(Stuff stuff: stuffs){
                if(stuff.getStuffHistory().getRank().getBranch().equals(branch)){
                    activeStuff.add(stuff);
                }
            }
            for(Stuff stuff : activeStuff){
                List<FacilityRequest> reqs=this.facilityRequestRepository.findByStuff_Id(stuff.getPersonalNumber());
                if (reqs.size()<this.BUSY_STUFF){
                    FacilityRequest facilityRequest=new FacilityRequest();
                    facilityRequest.setCashType(createFacilityRequest.getCashType());
                    facilityRequest.setTitle(createFacilityRequest.getTypeOfFacility());
                    facilityRequest.setTypeOfGranty(createFacilityRequest.getWarantyType());
                    facilityRequest.setStuff(stuff);
                    response=new Response(ResponseStatus.OK,2000);
                    this.facilityRequestRepository.save(facilityRequest);
                }
            }
        }else{throw new BadArgumentException();}
        return response;
    }
    public List<Facility> reportFacility(long userID){
        List<Facility> facilities = this.facilityRepository.findAll();
        List<Facility> facilities1 =new ArrayList<>();
        for(Facility facility:facilities){
            if(facility.getCustomer().getId().equals(userID)){
                facilities1.add(facility);
            }
        }
        return facilities1;
    }
    public String createRegularReturnFacility(CreateRegularReturnFacilityRequest createRegularReturnFacilityRequest){
        return null;
    }
    public String createReturnFacility(CreateReturnFacility createReturnFacility){
        return null;
    }
    public List<FacilityReturn> reportRegularReturnFacility(long userID){
        return this.facilityReturnRepository.findByFacility_Customer_Id(userID);
    }
    public List<Request> reportRequest(long userID){
        List<Request> requests = new ArrayList<>();
        requests.addAll(this.checkBookRequestRepository.findByCustomer_Id(userID));
        requests.addAll(this.facilityRequestRepository.findByCustomer_Id(userID));
        requests.addAll(this.accessCardRequestRepository.findByCustomer_Id(userID));
        return requests;
    }
    @Scheduled(fixedDelay = 86400000)
    public void profitCalculationOfShortTimeAccount() {
        List<Account> accounts =this.accountRepository.findByAccountTypeEquals(AccountType.SEPORDE_KOTAH);
        for(int counter=0;counter<accounts.size();counter++){
            Account account=accounts.get(counter);
            double temp=(account.getCash()*PORIFT_RATE_SHORT_TIME_ACCOUNT*account.getLongPeriod())/36500;
            account.setCash(account.getCash()+temp);
            this.accountRepository.updateCashValue(account.getCash(),account.getId());//TODO
        }
    }
    @Scheduled(fixedDelay = 259200000)//mah
    public void profitCalculationOfLongTimeAccount() {

        List<Account> accounts =this.accountRepository.findByAccountTypeEquals(AccountType.SEPORDE_BOLAND);
        for(int counter=0;counter<accounts.size();counter++){
            Account account=accounts.get(counter);
            double temp=account.getCash()*PORIFT_RATE_LONG_TIME_ACCOUNT/12;
            account.setCash(account.getCash()+temp);
            this.accountRepository.updateCashValue(account.getCash(),account.getId());//TODO
        }
    }
    private List<AccountFlowResponse> getDraft (AccountFlowRequest accountFlowRequest){
        List<AccountFlowResponse> responses=new ArrayList<>();
        List<Draft> drafts  = this.draftRepository.findBySourceAccount_AccountNumberOrDistAccount_AccountNumberOrderByDraftedDate(
                accountFlowRequest.getAccountNumber(),accountFlowRequest.getAccountNumber());

        for ( Draft draft : drafts){
            AccountFlowResponse accountFlowResponse =new AccountFlowResponse();
            accountFlowResponse.setDate(draft.getDraftedDate());
            accountFlowResponse.setAmount(draft.getAmount());
            if(draft.getSourceAccount().getAccountNumber().equals(accountFlowRequest.getAccountNumber())){
                accountFlowResponse.setAccountFlowType(AccountFlowType.HAVALE_BARDASHT);
                accountFlowResponse.setPayOrNot(true);
            }else{
                accountFlowResponse.setAccountFlowType(AccountFlowType.HAVALE_VARIZ);
                accountFlowResponse.setPayOrNot(false);
            }
            responses.add(accountFlowResponse);
        }
        return responses ;
    }
    private List<AccountFlowResponse> getAccountFlow(AccountFlowRequest accountFlowRequest , boolean all){
        List<AccountFlowResponse> responses=new ArrayList<>();
        List<AccountFlow> accountFlows;
        if(all){
            accountFlows = this.accountFlowRepository.findByAccount_AccountNumberOrderByDate(accountFlowRequest.getAccountNumber());
        }else {
             accountFlows = this.accountFlowRepository.findByAccount_AccountNumberAndTypeOrderByDate( accountFlowRequest.getAccountNumber(), accountFlowRequest.getAccountFlowType());
        }
        for  (AccountFlow accountFlow : accountFlows){
            AccountFlowResponse accountFlowResponse =new AccountFlowResponse();
            accountFlowResponse.setAccountFlowType(accountFlow.getType());
            accountFlowResponse.setAmount(accountFlow.getAmount());
            accountFlowResponse.setDate(accountFlow.getDate());
            if(accountFlow.getType().equals(AccountFlowType.KHARID_INTERNET)
                    || accountFlow.getType().equals(AccountFlowType.KHARID_POZ)
                    || accountFlow.getType().equals(AccountFlowType.PAYBILL)
                    ){
                accountFlowResponse.setPayOrNot(true);
            }else{
                accountFlowResponse.setPayOrNot(false);
            }
            responses.add(accountFlowResponse);
        }
        return responses;
    }
}
