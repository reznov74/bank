package software.eng.project.bank.core.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Account.Check;
import software.eng.project.bank.core.model.Request.Request;
import software.eng.project.bank.core.model.Response.RequestResponse;
import software.eng.project.bank.core.service.StuffService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/stuff")
public class StuffController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private StuffService stuffService;

    @RequestMapping(value = "/get/requests",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Request> getRequests(HttpServletResponse response, HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        List<Request> res = null ;
        try{
            res=this.stuffService.getRequests();
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }
    @RequestMapping(value = "/get/request/{requestID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Request getRequest(HttpServletResponse response,HttpServletRequest request ,@PathVariable("requestID") long requestID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Request res = null ;
        try{
            res=this.stuffService.getRequest(requestID);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }

    @RequestMapping(value = "/request/answer", ////difrrent controller for diffrent request
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String answerRequest(HttpServletResponse response, HttpServletRequest request , @RequestBody RequestResponse requestResponse)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        String res = null ;
        try{
            res=this.stuffService.answerRequest(requestResponse);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }


    @RequestMapping(value = "/request/redirect/{requestID}/{userID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String redirectRequest(HttpServletResponse response,HttpServletRequest request,@PathVariable("requestID") long requestID,@PathVariable("userID") long userID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        String res = null ;
        try{
            res=this.stuffService.redirectRequest(requestID,userID);
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
    String createAccount(HttpServletResponse response, HttpServletRequest request , @RequestBody Account account)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        String res = null ;
        try{
            res=this.stuffService.createAccount(account);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }
    @RequestMapping(value = "/pass/check",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String passCheck(HttpServletResponse response, HttpServletRequest request, @RequestBody Check check)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        String res = null ;
        try{
            res=this.stuffService.passCheck(check);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }



}
