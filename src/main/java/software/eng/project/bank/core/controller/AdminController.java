package software.eng.project.bank.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import software.eng.project.bank.core.model.Account.Account;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/add/user",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void addUser(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }
    @RequestMapping(value = "/remove/user",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void removeUser(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }
    @RequestMapping(value = "/change/user",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void changeUser(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }

    @RequestMapping(value = "/get/log",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void getLog(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }
}
