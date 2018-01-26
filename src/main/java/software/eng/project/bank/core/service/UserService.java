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
import software.eng.project.bank.core.model.Request.*;
import software.eng.project.bank.core.model.Role.Stuff;
import software.eng.project.bank.core.repository.*;
import software.eng.project.bank.core.util.Util;
import software.eng.project.bank.security.JwtTokenUtil;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private static double MAX_AMOUNT = 1000000000;
    private static int BUSY_STUFF = 10;

    private static int PORIFT_RATE_SHORT_TIME_ACCOUNT=7;

    private static int PORIFT_RATE_LONG_TIME_ACCOUNT=20;

    @Autowired
    private AccountStatusRepository accountStatusRepository;

    @Autowired
    private ProfitRepository profitRepository;

    @Autowired
    private CheckRepository checkRepository;
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
    public Draft createDraft(CreateDraftRequest createDraftRequest , long userID) throws BadArgumentException {
        Account source =this.accountRepository.findByAccountNumber(createDraftRequest.getSourceAccount());
        Account dist =this.accountRepository.findByAccountNumber(createDraftRequest.getDistAccount());
        boolean meToMe =false ;
        if(!source.getCustomer().getId().equals(userID)){
            throw new BadArgumentException();
        }
        if(source.getAccountStatus().getStatusType().equals(AccountStatusType.BLOCKED)
                || dist.getAccountStatus().getStatusType().equals(AccountStatusType.BLOCKED)){
            throw new BadArgumentException();
        }
        if (dist.getCustomer().getId()
                .equals(source.getCustomer().getId())) {
            meToMe =true;
        }
        if(!meToMe && createDraftRequest.getType()==null){
            throw new BadArgumentException();
        }
        else {
            Draft draft = new Draft();
            if (!meToMe) {
                if (createDraftRequest.getAmount() > MAX_AMOUNT) {
                    throw new BadArgumentException();
                }
            }
            if (source.getCash() > createDraftRequest.getAmount()) {
                source.setCash(source.getCash() - createDraftRequest.getAmount());
                dist.setCash(dist.getCash() + createDraftRequest.getAmount());
                this.accountRepository.updateCashValue(dist.getCash(), dist.getId());
                this.accountRepository.updateCashValue(source.getCash(), source.getId());
                draft = new Draft();
                draft.setAmount(createDraftRequest.getAmount());
                draft.setDistAccount(this.accountRepository.findByAccountNumber(createDraftRequest.getDistAccount()));
                draft.setSourceAccount(this.accountRepository.findByAccountNumber(createDraftRequest.getSourceAccount()));
                draft.setDraftType(DraftType.INTERNET);
                draft.setFowWhy(createDraftRequest.getForWhy());
                draft.setDraftedDate(new Date());
                draft = this.draftRepository.save(draft);
            }
            return draft;
        }
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
        if(this.accountRepository.findOne(accountID).getCustomer().getId().equals(userID)){
            return this.accountRepository.getOne(accountID);
        }else{
            throw new BadArgumentException();
        }
    }
    public List<Check> getReportCheck(long userID){
        List<Check> checkBooks  =this.checkRepository.findByCheckBook_Account_Customer_Id(userID);
        return checkBooks;
    }
    //
    public Account createAccount(CreateAccountRequest createAccountRequest , long userID) throws BadArgumentException {
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
                    AccountStatus accountStatus = new AccountStatus();
                    accountStatus.setStartDate(new Date());
                    accountStatus.setStatusType(AccountStatusType.OPEN);
                    accountStatus = this.accountStatusRepository.save(accountStatus);
                    account1.setAccountStatus(accountStatus);
                    account1.setStartDate(new Date());
                    account1.setCreateBranch(this.branchRepository.findByBarnchCode(createAccountRequest.getBranchCode()));
                    account1.setAccountNumber(Util.accountNumberGenerator(16));
                    account1=this.accountRepository.save(account1);
                    this.createDraft(new CreateDraftRequest(createAccountRequest.getInitCash(),account.getAccountNumber(),account1.getAccountNumber(),null, null ),userID);
                }else {throw new BadArgumentException();}
            }
        }else{throw new BadArgumentException();}
        return account1;
    }

    public List<Profit> reportProfitAccount(long accountID , long userID) throws BadArgumentException {
        if(!this.accountRepository.findOne(accountID).getCustomer().getId().equals(userID)){
            throw new BadArgumentException();
        }
        return this.profitRepository.findByAccount_Id(accountID);
    }

    public List<Account> reportBlockedAccount(long uerID){
        return this.accountRepository.findByCustomer_IdAndAccountStatus_StatusType(uerID , AccountStatusType.BLOCKED);
    }

    public Response requestCheckbook(CreateCheckbookRequest createCheckbookRequest,long userID) throws BadArgumentException {
        Response response=new Response();
        Account account =this.accountRepository.getOne(createCheckbookRequest.getAccountID());
        if(!this.accountRepository.findOne(createCheckbookRequest.getAccountID()).
                getAccountStatus().getStatusType().equals(AccountStatusType.OPEN)){
            throw new BadArgumentException();
        }
        if(!this.accountRepository.findOne(createCheckbookRequest.getAccountID()).getCustomer().getId().equals(userID)){
            throw new BadArgumentException();
        }
        if(account.isWithChek()){
            //for(CheckBook checkBook : account.getCheckBook()){
                //Date date = new Date();
                //if(!checkBook.getExpireDate().before(date)){
                    Branch branch=this.branchRepository.findOne(createCheckbookRequest.getBranchID());
                    if(branch!=null){
                        List<Stuff> stuffs= this.stuffRepository.findAll();
                        List<Stuff> activeStuff =new ArrayList<>();
                        for(Stuff stuff: stuffs){
                            if(stuff.getBranch().equals(branch)){
                                activeStuff.add(stuff);
                            }
                        }
                        for(Stuff stuff : activeStuff){
                            List<CheckBookRequest> reqs=this.checkBookRequestRepository.findByStuff_IdAndStatus(stuff.getPersonalNumber(), RequestStatus.NOT_OPEN);
                            if (reqs.size()<this.BUSY_STUFF){
                                CheckBookRequest checkBookRequest=new CheckBookRequest();
                                checkBookRequest.setAccount(this.accountRepository.findOne(createCheckbookRequest.getAccountID()));
                                checkBookRequest.setStuff(stuff);
                                checkBookRequest.setStatus(RequestStatus.NOT_OPEN);
                                checkBookRequest.setRequestDate(new Date());
                                response=new Response(ResponseStatus.OK,2000);
                                this.checkBookRequestRepository.save(checkBookRequest);
                                break;
                            }
                        }
                    }else{throw new BadArgumentException();}

//                }else{
//                    throw new BadArgumentException();
//                }
            //}
        }else{throw new BadArgumentException();}
        return response;
    }
    public void requestCard(CreateCardRequest createCardRequest,long userID) throws BadArgumentException {
        boolean isFirstOne=true;
        Account account =this.accountRepository.findOne(createCardRequest.getAccountID());
        if(!this.accountRepository.findOne(createCardRequest.getAccountID()).
                getAccountStatus().getStatusType().equals(AccountStatusType.OPEN)){
            throw new BadArgumentException();
        }
        if(!this.accountRepository.findOne(createCardRequest.getAccountID()).getCustomer().getId().equals(userID)){
            throw new BadArgumentException();
        }
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
                if(stuff.getBranch().equals(branch)){
                    activeStuff.add(stuff);
                }
            }
            for(Stuff stuff : activeStuff){
                List<AccessCardRequest> reqs=this.accessCardRequestRepository.findByStuff_IdAndStatus(stuff.getPersonalNumber() , RequestStatus.NOT_OPEN);
                if (reqs.size()<this.BUSY_STUFF){
                    AccessCardRequest accessCardRequest =new AccessCardRequest();
                    accessCardRequest.setFristOrNot(isFirstOne);
                    accessCardRequest.setAccount(this.accountRepository.findOne(createCardRequest.getAccountID()));
                    accessCardRequest.setStuff(stuff);
                    accessCardRequest.setRequestDate(new Date());
                    accessCardRequest.setStatus(RequestStatus.NOT_OPEN);
                    this.accessCardRequestRepository.save(accessCardRequest);
                    return ;
                }
            }

        }else{throw new BadArgumentException();}
    }
    public void requestFacility(CreateFacilityRequest createFacilityRequest , long customerID) throws BadArgumentException {
        Branch branch=this.branchRepository.findOne(createFacilityRequest.getBranchID());
        if(branch!=null){
            List<Stuff> stuffs= this.stuffRepository.findAll();
            List<Stuff> activeStuff =new ArrayList<>();
            for(Stuff stuff: stuffs){
                if(stuff.getBranch().equals(branch)){
                    activeStuff.add(stuff);
                }
            }
            for(Stuff stuff : activeStuff){
                List<FacilityRequest> reqs=this.facilityRequestRepository.findByStuff_IdAndStatus(stuff.getPersonalNumber() , RequestStatus.NOT_OPEN);
                if (reqs.size()<this.BUSY_STUFF){
                    FacilityRequest facilityRequest=new FacilityRequest();
                    facilityRequest.setCashType(createFacilityRequest.getCashType());
                    facilityRequest.setTitle(createFacilityRequest.getTypeOfFacility());
                    facilityRequest.setTypeOfGranty(createFacilityRequest.getWarantyType());
                    facilityRequest.setStuff(stuff);
                    facilityRequest.setStatus(RequestStatus.NOT_OPEN);
                    facilityRequest.setRequestDate(new Date());
                    facilityRequest.setAccount(this.accountRepository.findOne(createFacilityRequest.getAccountID()));
                    this.facilityRequestRepository.save(facilityRequest);
                    return ;
                }
            }
        }else{throw new BadArgumentException();}
    }
    public List<Facility> reportFacility(long userID){
        return this.facilityRepository.findByAccount_Customer_Id(userID);
    }
    public String createRegularReturnFacility(CreateRegularReturnFacilityRequest createRegularReturnFacilityRequest){
        return null;
    }
    public String createReturnFacility(CreateReturnFacility createReturnFacility){
        return null;
    }
    public List<FacilityReturn> reportRegularReturnFacility(long userID){
        return this.facilityReturnRepository.findByFacility_Account_Customer_Id(userID);
    }
    public List<Request> reportRequest(long userID){
        List<Request> requests = new ArrayList<>();
        requests.addAll(this.checkBookRequestRepository.findByAccount_Customer_Id(userID));
        requests.addAll(this.facilityRequestRepository.findByAccount_Customer_Id(userID));
        requests.addAll(this.accessCardRequestRepository.findByAccount_Customer_Id(userID));
        return requests;
    }

    public List<Branch> branchList(){
        return this.branchRepository.findAll();
    }

    @Scheduled(fixedDelay = 864000000)
    public void profitCalculationOfShortTimeAccount() {
        List<Account> accounts =this.accountRepository.findByAccountTypeEquals(AccountType.SEPORDE_KOTAH);
        for(int counter=0;counter<accounts.size();counter++){
            Account account=accounts.get(counter);
            if(account.getAccountStatus().getStatusType().equals(AccountStatusType.OPEN)) {
                double temp = (account.getCash() * PORIFT_RATE_SHORT_TIME_ACCOUNT * account.getLongPeriod()) / 36500;
                account.setCash(account.getCash() + temp);
                this.accountRepository.updateCashValue(account.getCash(), account.getId());//TODO
                this.saveProfit(account, temp);
            }
        }
    }
    @Scheduled(fixedDelay = 259000000)//mah
    public void profitCalculationOfLongTimeAccount() {

        List<Account> accounts =this.accountRepository.findByAccountTypeEquals(AccountType.SEPORDE_BOLAND);
        for(int counter=0;counter<accounts.size();counter++){
            Account account=accounts.get(counter);
            if(account.getAccountStatus().getStatusType().equals(AccountStatusType.OPEN)) {
                double temp = account.getCash() * PORIFT_RATE_LONG_TIME_ACCOUNT / 12;
                account.setCash(account.getCash() + temp);
                this.accountRepository.updateCashValue(account.getCash(), account.getId());//TODO
                this.saveProfit(account, temp);
            }
        }
    }
    private void saveProfit(Account account , double temp){
        Profit profit =new Profit();
        profit.setAccount(account);
        profit.setAmount(temp);
        profit.setDate(new Date());
        this.profitRepository.save(profit);
        AccountFlow accountFlow=new AccountFlow();
        accountFlow.setAccount(account);
        accountFlow.setAmount(temp);
        accountFlow.setDate(new Date());
        accountFlow.setType(AccountFlowType.VARIZ_SOOD);
        this.accountFlowRepository.save(accountFlow);
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
