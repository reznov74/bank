package software.eng.project.bank.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.ResponseStatus;
import software.eng.project.bank.core.Exception.UserNotFoundException;
import software.eng.project.bank.core.boundry.request.*;
import software.eng.project.bank.core.boundry.response.*;
import software.eng.project.bank.core.model.Account.*;
import org.springframework.web.bind.annotation.RequestBody;
import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Request.Request;
import software.eng.project.bank.core.model.Role.Customer;
import software.eng.project.bank.core.model.Role.Stuff;
import software.eng.project.bank.core.repository.CustomerRepository;
import software.eng.project.bank.core.service.UserService;
import com.google.common.base.Preconditions;
import software.eng.project.bank.security.JwtTokenUtil;
import software.eng.project.bank.security.JwtUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerRepository customerRepository;

    //OK
    @RequestMapping(value = "/home",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Account> getAccounts(HttpServletResponse response,HttpServletRequest request)//IMPL
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Account> res = null ;
        try{
            res=this.userService.getAccountList(this.getCustomerID(token));
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

    //OK
    @RequestMapping(value = "/account/flow",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<AccountFlowResponse> getAccountAccountFlow(HttpServletResponse response, HttpServletRequest request , @RequestBody AccountFlowRequest accountFlowRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<AccountFlowResponse> res = null ;
        try{
            res=this.userService.getAccountFlow(accountFlowRequest,this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //TODO
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

    //TODO
    @RequestMapping(value = "/pay/bill",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Response payBill(HttpServletResponse response , HttpServletRequest request , @RequestBody PayBillRequest payBillRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.userService.payBill(payBillRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }


    //TODO
    @RequestMapping(value = "/pay/rejected/check",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void payRejectedCheck(HttpServletResponse response , HttpServletRequest request , @RequestBody PayBillRequest payBillRequest)
    {

    }

    //OK
    @RequestMapping(value = "/branch/list",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Branch> getBranchList(HttpServletResponse response , HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Branch> res = null ;
        try{
            res=this.userService.branchList();
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }


    //OK
    @RequestMapping(value = "/create/draft",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Draft createDraft(HttpServletResponse response,HttpServletRequest request,@RequestBody CreateDraftRequest createDraftRequest)
    {
        //TODO CHECK FOR SOURCE ACCOUNT BELONG TO USERID THTA REQUESTED
        //TODO FROM BLOCKED ACCOUNT WE CANT HAVE DRAFT
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Draft res = null ;
        try{
            res=this.userService.createDraft(createDraftRequest , this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //TODO
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
            res=this.userService.reportDraftRequest(reportDraftRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //TODO
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

    //TODO
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

    //TODO
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

    //TODO
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
    //TODO
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

    //TODO
    @RequestMapping(value = "/accept/group/draft/{draftID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Response acceptGroupDraft(HttpServletResponse response, HttpServletRequest request, @PathVariable("draftID") long draftID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.userService.acceptGroupDraft(draftID);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    /////////////




    //TODO SHOULD CHANGE FORM ACCOUNT ID TO ACCOUNT NUMBER
    //OK
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
            res=this.userService.getAccountInfo(accoundID,this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //OK
    @RequestMapping(value = "/report/check",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Check> reportCheck(HttpServletResponse response,HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Check> res = null ;
        try{
            res=this.userService.getReportCheck(this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //TODO TEST
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
            res=this.userService.createAccount(createAccountRequest , this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }


    //OK
    @RequestMapping(value = "/report/profit/{accountID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Profit> reportProfitAccount(HttpServletResponse response, HttpServletRequest request, @PathVariable("accountID") long accountID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Profit> res = null ;
        try{
            res=this.userService.reportProfitAccount(accountID , this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //OK
    @RequestMapping(value = "/report/blocked/account",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Account> reportBlockedAccount(HttpServletResponse response, HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Account> res = null ;
        try{
            res=this.userService.reportBlockedAccount(this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }


    //OK
    @RequestMapping(value = "/request/checkbook",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Response requestCheckbook(HttpServletResponse response, HttpServletRequest request, @RequestBody CreateCheckbookRequest createCheckbookRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.userService.requestCheckbook(createCheckbookRequest,this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //OK
    @RequestMapping(value = "/request/card",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Response requestCard(HttpServletResponse response,HttpServletRequest request, @RequestBody CreateCardRequest createCardRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.userService.requestCard(createCardRequest,this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }
    //OK
    @RequestMapping(value = "/request/facility",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Response requestFacility(HttpServletResponse response,HttpServletRequest request,@RequestBody CreateFacilityRequest createFacilityRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.userService.requestFacility(createFacilityRequest , this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //OK
    @RequestMapping(value = "/report/request",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Request> reportRequest(HttpServletResponse response, HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Request> res = null ;
        try{
            res=this.userService.reportRequest(this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    //TODO
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
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        String res = null ;
        try{
            res=this.userService.createRegularReturnFacility(createRegularReturnFacilityRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/report/return/facility",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<FacilityReturn> reportRegularReturnFacility(HttpServletResponse response,HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<FacilityReturn> res = null ;
        try{
            res=this.userService.reportRegularReturnFacility(this.getCustomerID(token));
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }
    public long getCustomerID(String token){
        token=token.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
        Customer customer =this.customerRepository.findByUser_Id(jwtUser.getId());
        return customer.getId();
    }
}
