package software.eng.project.bank.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import software.eng.project.bank.core.domian.ChechBookRequestResponse;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Request.CheckBookRequest;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletResponse;

import static com.sun.tools.doclint.Entity.para;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @RequestMapping(value = "/accounts",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Account getAccounts(HttpServletResponse response)
    {
        response.setStatus(200);
        //get user information from jwt
        return null;
    }
    @RequestMapping(value = "/request/checkbook",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    public @ResponseBody
    ChechBookRequestResponse chechbookRequest(@RequestBody CheckBookRequest request,HttpServletResponse response)
    {
        response.setStatus(200);
        return null;
    }


}
