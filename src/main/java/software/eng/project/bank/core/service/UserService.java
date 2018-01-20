package software.eng.project.bank.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.eng.project.bank.core.Exception.BadArgumentException;
import software.eng.project.bank.core.Exception.UserNotFoundException;
import software.eng.project.bank.core.boundry.request.*;
import software.eng.project.bank.core.boundry.response.*;
import software.eng.project.bank.core.model.Account.*;
import software.eng.project.bank.core.model.Request.Request;
import software.eng.project.bank.core.repository.AccountFlowRepository;
import software.eng.project.bank.core.repository.AccountRepository;
import software.eng.project.bank.core.repository.DraftRepository;
import software.eng.project.bank.security.JwtTokenUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static long MAX_DRAFT_AMOUNT=100000000;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountFlowRepository accountFlowRepository;

    @Autowired
    private DraftRepository draftRepository;
    public List<Account> getAccountList () throws UserNotFoundException {
        List<Account> queryResult = this.accountRepository.findAll();
        List<Account> ans=new ArrayList<>();
        for(Account account : queryResult){
            if(account.getAccountStatus().getStatusType().equals(AccountStatusType.OPEN)){

            }
        }
        return ans;
    }
    public List<AccountFlow> getAccountFlow(AccountFlowRequest accountFlowRequest , long userID) throws BadArgumentException{
        List<AccountFlow> resultQuery=this.accountFlowRepository.findAll();
        if(this.accountRepository.findOne(accountFlowRequest.getAccount()).getCustomer().getId()!=userID){
            throw new BadArgumentException();
        }
        List<AccountFlow> ans=new ArrayList<>();
        for(AccountFlow accountFlow:resultQuery){
            if(accountFlow.getSourceAccount().equals(accountFlowRequest.getAccount()) ||
                    accountFlow.getDistAccount().equals(accountFlowRequest.getAccount())){
                ans.add(accountFlow);
            }
        }
        return ans;
    }
    public ResponseEntity<InputStreamResource> getReceiveAccountFlow(){
        return null;
    }
    public Response payBill(PayBillRequest payBillRequest){
        return null;
    }
    public Draft createDraft(CreateDraftRequest createDraftRequest) throws BadArgumentException {
        if(!this.accountRepository.findOne(createDraftRequest.getDistAccount()).getCustomer().getId()
                .equals(this.accountRepository.findOne(createDraftRequest.getSourceAccount()))){
            if(createDraftRequest.getAmount()>this.MAX_DRAFT_AMOUNT){
                throw new BadArgumentException();
            }
        }
        Draft draft =new Draft();
        draft.setAmount(createDraftRequest.getAmount());
        draft.setDistAccount(this.accountRepository.findOne(createDraftRequest.getDistAccount()));
        draft.setDraftType(DraftType.INTERNET);
        draft.setFowWhy(createDraftRequest.getForWhy());
        draft.setMaxAmount(this.MAX_DRAFT_AMOUNT);
        return this.draftRepository.save(draft);
    }
    public List<Draft> reportDraftRequest(ReportDraftRequest reportDraftRequest){
        return null;
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
    public List<GroupDraft> getRequestedGroupDraft(){
        return null;
    }
    public GroupDraft createGroupDraft(CreateGroupDraftRequest createGroupDraftRequest){
        return null;
    }
    public Response acceptGroupDraft(long draftID){
        return null;
    }
    public Account getAccountInfo(long accountID){
        return null;
    }
    public CheckBook getReportCheck(){
        return null;
    }
    public Account createAccount(CreateAccountRequest createAccountRequest){
        return null;
    }
    public ReportProfitResponse reportProfitAccount(long accountID){
        return null;
    }
    public List<Account> reportBlockedAccount(){
        return null;
    }
    public Response requestCheckbook(CreateCheckbookRequest createCheckbookRequest){
        return null;
    }
    public Response requestCard(CreateCardRequest createCardRequest){
        return null;
    }
    public Response requestFacility(CreateFacilityRequest createFacilityRequest){
        return null;
    }
    public List<Facility> reportFacility(long accountID){
        return null;
    }
    public String createRegularReturnFacility(CreateRegularReturnFacilityRequest createRegularReturnFacilityRequest){
        return null;
    }
    public String createReturnFacility(CreateReturnFacility createReturnFacility){
        return null;
    }
    public List<FacilityReturn> reportRegularReturnFacility(){
        return null;
    }
    public List<Request> reportRequest(){
        return null;
    }
}
