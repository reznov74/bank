package software.eng.project.bank.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import software.eng.project.bank.core.model.Account.Account;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

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
}
