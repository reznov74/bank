package software.eng.project.bank.core.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import software.eng.project.bank.core.boundry.response.CreateFacilityResponse;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Role.User;
import software.eng.project.bank.core.service.AdminService;
import software.eng.project.bank.core.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/add/user",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    User addUser(HttpServletResponse response, HttpServletRequest request, @RequestBody User user)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        User res = null ;
        try{
            res=this.adminService.addUser(user);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;
    }
    @RequestMapping(value = "/remove/user/{userID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    User removeUser(HttpServletResponse response,HttpServletRequest request , @PathVariable("userID") long userID)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        User res = null ;
        try{
            res=this.adminService.removeUser(userID);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;

    }
    @RequestMapping(value = "/change/user",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    User changeUser(HttpServletResponse response,HttpServletRequest request,@RequestBody User user)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        User res = null ;
        try{
            res=this.adminService.changeUser(user);
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;

    }

    @RequestMapping(value = "/get/log",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String getLog(HttpServletResponse response,HttpServletRequest request)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        String res = null ;
        try{
            res=this.adminService.getLog();
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(500);
        }
        return res;

    }
}
