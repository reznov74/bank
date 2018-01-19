package software.eng.project.bank.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import software.eng.project.bank.core.Exception.UserNotFoundException;
import software.eng.project.bank.core.boundry.request.*;
import software.eng.project.bank.core.boundry.response.*;
import software.eng.project.bank.core.model.Account.*;
import software.eng.project.bank.core.model.Request.CheckBookRequest;
import org.springframework.web.bind.annotation.RequestBody;
import software.eng.project.bank.core.model.Response.ChechBookRequestResponse;
import software.eng.project.bank.core.service.UserService;
import com.google.common.base.Preconditions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/home",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Account> getAccounts(HttpServletResponse response,HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Account> res = null ;
        try{
            res=this.userService.getAccountList();
            response.setStatus(200);
        }catch(UserNotFoundException e){
            e.printStackTrace();
            response.setStatus(401);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        //get user information from jwt
        return res;
    }
    /////////////////////////////////

    @RequestMapping(value = "/account/flow",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<AccountFlow> getAccountAccountFlow(HttpServletResponse response, HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<AccountFlow> res = null ;
        try{
            res=this.userService.getAccountFlow();
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/receive/account/flow",
            method = RequestMethod.POST,
            produces = {"application/pdf"})
    @ResponseStatus(HttpStatus.OK)
    public
    ResponseEntity<InputStreamResource> receiveAccountFlow(HttpServletResponse response ,HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Object res = null ;
        try{
            res=this.userService.getReceiveAccountFlow();
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return (ResponseEntity<InputStreamResource>) res;
    }

    @RequestMapping(value = "/pay/bill",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    PayBillResponse payBill(HttpServletResponse response , HttpServletRequest request , @RequestBody PayBillRequest payBillRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        PayBillResponse res = null ;
        try{
            res=this.userService.payBill(payBillRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/create/draft",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Draft createDraft(HttpServletResponse response,HttpServletRequest request,@RequestBody CreateDraftRequest createDraftRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Draft res = null ;
        try{
            res=this.userService.createDraft(createDraftRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/report/draft",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Draft> getDraftReport(HttpServletResponse response,HttpServletRequest request,@RequestBody ReportDraftRequest reportDraftRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Draft> res = null ;
        try{
            res=this.userService.getDraftRequest(reportDraftRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/create/draft/regular",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    RegularDraft createRegularDraft(HttpServletResponse response,HttpServletRequest request,@RequestBody CreateRegularDraftRequest createRegularDraftRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        RegularDraft res = null ;
        try{
            res=this.userService.createRegularDraft(createRegularDraftRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/report/regular/draft",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<RegularDraft> reportRegularDraft(HttpServletResponse response,HttpServletRequest request,@RequestBody ReportDraftRequest reportDraftRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<RegularDraft> res = null ;
        try{
            res=this.userService.reportRegularDraft(reportDraftRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/report/group/draft",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<GroupDraft> reportGroupDraft(HttpServletResponse response, HttpServletRequest request,@RequestBody ReportDraftRequest reportDraftRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<GroupDraft> res = null ;
        try{
            res=this.userService.reportGroupDraft(reportDraftRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/get/request/group/draft",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<GroupDraft> requestGroupDraft(HttpServletResponse response , HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<GroupDraft> res = null ;
        try{
            res=this.userService.getRequestedGroupDraft();
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/create/group/draft",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    GroupDraft createGroupDraft(HttpServletResponse response, HttpServletRequest request,@RequestBody CreateGroupDraftRequest createGroupDraftRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        GroupDraft res = null ;
        try{
            res=this.userService.createGroupDraft(createGroupDraftRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/accept/group/draft/{draftID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    AcceptGroupDraftResponse acceptGroupDraft(HttpServletResponse response, HttpServletRequest request, @PathVariable("draftID") long draftID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        AcceptGroupDraftResponse res = null ;
        try{
            res=this.userService.acceptGroupDraft(draftID);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/account/info/{accountID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)

    public @ResponseBody
    Account getAccountInfo(HttpServletResponse response, HttpServletRequest request , @PathVariable("accountID") long accoundID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Account res = null ;
        try{
            res=this.userService.getAccountInfo(accoundID);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/report/check",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CheckBook reportCheck(HttpServletResponse response,HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        CheckBook res = null ;
        try{
            res=this.userService.getReportCheck();
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/create/account",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account createAccount(HttpServletResponse response,  HttpServletRequest request , @RequestBody CreateAccountRequest createAccountRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Account res = null ;
        try{
            res=this.userService.createAccount(createAccountRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }


    @RequestMapping(value = "/report/profit/{accountID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ReportProfitResponse reportProfitAccount(HttpServletResponse response, HttpServletRequest request, @PathVariable("accountID") long accountID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        ReportProfitResponse res = null ;
        try{
            res=this.userService.reportProfitAccount(accountID);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/report/blocked/account",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ReportBlockedAccountResponse reportBlockedAccount(HttpServletResponse response, HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        ReportBlockedAccountResponse res = null ;
        try{
            res=this.userService.reportBlockedAccount();
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/request/checkbook",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CreateCheckbookResponse requestCheckbook(HttpServletResponse response, HttpServletRequest request, @RequestBody CreateCheckbookRequest createCheckbookRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        CreateCheckbookResponse res = null ;
        try{
            res=this.userService.requestCheckbook(createCheckbookRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/request/card",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CreateCardResponse requestCard(HttpServletResponse response,HttpServletRequest request, @RequestBody CreateCardRequest createCardRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        CreateCardResponse res = null ;
        try{
            res=this.userService.requestCard(createCardRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/request/facility",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CreateFacilityResponse requestFacility(HttpServletResponse response,HttpServletRequest request,@RequestBody CreateFacilityRequest createFacilityRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        CreateFacilityResponse res = null ;
        try{
            res=this.userService.requestFacility(createFacilityRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/report/facility/{accountID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Facility> reportFacility(HttpServletResponse response,HttpServletRequest request,@PathVariable("accountID") long accountID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Facility> res = null ;
        try{
            res=this.userService.reportFacility(accountID);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/create/return/facility",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String createReturnFacility(HttpServletResponse response,HttpServletRequest request,@RequestBody CreateReturnFacility createReturnFacility)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        String res = null ;
        try{
            res=this.userService.createReturnFacility(createReturnFacility);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/create/regular/return/facility",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String createRegularReturnFacility(HttpServletResponse response,HttpServletRequest request,@RequestBody CreateRegularReturnFacilityRequest createRegularReturnFacilityRequest)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/report/return/facility",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<FacilityReturn> createRegularReturnFacility(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }
}
