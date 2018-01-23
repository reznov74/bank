package software.eng.project.bank.core.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import software.eng.project.bank.core.boundry.request.CreateUserRequest;
import software.eng.project.bank.core.model.Role.Admin;
import software.eng.project.bank.core.model.Role.Customer;
import software.eng.project.bank.core.model.Role.UserModel;
import software.eng.project.bank.core.repository.AdminRepository;
import software.eng.project.bank.core.service.AdminService;
import software.eng.project.bank.security.JwtTokenUtil;
import software.eng.project.bank.security.JwtUser;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    AdminRepository adminRepository;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/add/user",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    UserModel addUser(HttpServletResponse response, HttpServletRequest request, @RequestBody CreateUserRequest user)//OK
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        UserModel res = null ;
        try{
            res=this.adminService.addUser(user,this.getAdminID(token));
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
    UserModel removeUser(HttpServletResponse response, HttpServletRequest request , @PathVariable("userID") long userID)//OK
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        UserModel res = null ;
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
    UserModel changeUser(HttpServletResponse response, HttpServletRequest request, @RequestBody UserModel user)
    {
        String token =request.getHeader(this.tokenHeader);
        Preconditions.checkNotNull(token);
        UserModel res = null ;
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
    public long getAdminID(String token){
        token = token.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
        Admin admin =this.adminRepository.findByUser_Id(jwtUser.getId());
        return admin.getId();
    }
}
