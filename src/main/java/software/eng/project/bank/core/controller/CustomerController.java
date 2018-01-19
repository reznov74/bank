package software.eng.project.bank.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import software.eng.project.bank.core.Exception.UserNotFoundException;
import software.eng.project.bank.core.domin.request.PayBillRequest;
import software.eng.project.bank.core.domin.response.PayBillResponse;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Account.AccountFlow;
import software.eng.project.bank.core.model.Request.CheckBookRequest;
import org.springframework.web.bind.annotation.RequestBody;
import software.eng.project.bank.core.model.Response.ChechBookRequestResponse;
import software.eng.project.bank.core.service.UserService;
import software.eng.project.bank.security.JwtTokenUtil;
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

    @RequestMapping(value = "/draft",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account draft(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/draft_gozaresh",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account draftGozaresh(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/create_regular_draft",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account createREgularDRaft(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/gozaresh_havale_monaam",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account gozareshHavaleMonazam(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/gozaresh_havale_gorohi",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account gozareshHavalegorohi(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/account_info",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)

    public @ResponseBody
    void AccountINfo(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }

    @RequestMapping(value = "/used_check_info",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account usedCheckInfo(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/create_acount",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account createAccount(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }


    @RequestMapping(value = "/moshahede_sood",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account moshahedeSood(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/blocked_Account",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account BlockedAccount(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/checkbook_request",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account checkBookRequest(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/crad_request",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account cardRequest(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/facility_request",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account fcilityRequest(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }

    @RequestMapping(value = "/gozaresh_facility",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account seeFacility(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }


    @RequestMapping(value = "/facility_regualr_return",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account createRegularReturn(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }








    /////////////////////
    @RequestMapping(value = "/request/checkbook",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    public @ResponseBody
    ChechBookRequestResponse chechbookRequest(@RequestBody CheckBookRequest request, HttpServletResponse response)
    {
        response.setStatus(200);
        return null;
    }


}
