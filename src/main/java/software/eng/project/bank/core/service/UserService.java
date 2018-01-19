package software.eng.project.bank.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.eng.project.bank.core.Exception.UserNotFoundException;
import software.eng.project.bank.core.boundry.request.*;
import software.eng.project.bank.core.boundry.response.*;
import software.eng.project.bank.core.model.Account.*;
import software.eng.project.bank.core.repository.AccountRepository;
import software.eng.project.bank.security.JwtTokenUtil;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountList () throws UserNotFoundException {
        return this.accountRepository.findAll();
    }
    public List<AccountFlow> getAccountFlow() {
        return null;
    }
    public ResponseEntity<InputStreamResource> getReceiveAccountFlow(){
        return null;
    }
    public PayBillResponse payBill(PayBillRequest payBillRequest){
        return null;
    }
    public Draft createDraft(CreateDraftRequest createDraftRequest){
        return null;
    }
    public List<Draft> getDraftRequest(ReportDraftRequest reportDraftRequest){
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
    public AcceptGroupDraftResponse acceptGroupDraft(long draftID){
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
    public ReportBlockedAccountResponse reportBlockedAccount(){
        return null;
    }
    public CreateCheckbookResponse requestCheckbook(CreateCheckbookRequest createCheckbookRequest){
        return null;
    }
    public CreateCardResponse requestCard(CreateCardRequest createCardRequest){
        return null;
    }
    public CreateFacilityResponse requestFacility(CreateFacilityRequest createFacilityRequest){
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

}
