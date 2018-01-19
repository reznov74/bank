package software.eng.project.bank.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/stuff")
public class StuffController {
    @RequestMapping(value = "/get/requests",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void getRequests(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }
    @RequestMapping(value = "/get/request/{requestID}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void getRequest(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }

    @RequestMapping(value = "/request/answer", ////difrrent controller for diffrent request
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void answerRequest(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }


    @RequestMapping(value = "/request/redirect",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void redirectRequest(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }

    @RequestMapping(value = "/create/account",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void createAccount(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }
    @RequestMapping(value = "/pass/check",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void createCheck(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt

    }



}
