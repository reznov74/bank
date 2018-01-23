package software.eng.project.bank.core.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import software.eng.project.bank.core.boundry.request.CheckPassRequest;
import software.eng.project.bank.core.boundry.request.CreateAccountRequest;
import software.eng.project.bank.core.boundry.request.CreateResponseRequest;
import software.eng.project.bank.core.boundry.response.Response;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Account.Check;
import software.eng.project.bank.core.model.Request.Request;
import software.eng.project.bank.core.model.Response.RequestResponse;
import software.eng.project.bank.core.model.Role.Stuff;
import software.eng.project.bank.core.repository.StuffRepository;
import software.eng.project.bank.core.service.StuffService;
import software.eng.project.bank.security.JwtTokenUtil;
import software.eng.project.bank.security.JwtUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/stuff")
public class StuffController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private StuffService stuffService;

    @Autowired
    private StuffRepository stuffRepository;

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
            res=this.stuffService.getRequests(this.getStuffID(token));
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
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Response answerRequest(HttpServletResponse response, HttpServletRequest request , @RequestBody CreateResponseRequest createResponseRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.stuffService.answerRequest(createResponseRequest,this.getStuffID(token));
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
    Response redirectRequest(HttpServletResponse response,HttpServletRequest request,@PathVariable("requestID") long requestID,@PathVariable("userID") long userID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.stuffService.redirectRequest(requestID,userID);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;

    }


    ///TODO ta inja



    @RequestMapping(value = "/create/account",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Response createAccount(HttpServletResponse response, HttpServletRequest request , @RequestBody CreateAccountRequest createAccountRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.stuffService.createAccount(createAccountRequest , this.getStuffID(token));
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
    Response passCheck(HttpServletResponse response, HttpServletRequest request, @RequestBody CheckPassRequest checkPassRequest)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        Response res = null ;
        try{
            res=this.stuffService.passCheck(checkPassRequest);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }
    @RequestMapping(value = "/get/stuff/list",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Response getStuffList(HttpServletResponse response,HttpServletRequest request)
    {
        return null;
    }

    public long getStuffID(String token){
        token = token.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
        Stuff stuff =this.stuffRepository.findByUser_Id(jwtUser.getId());
        return stuff.getId();
    }



}
