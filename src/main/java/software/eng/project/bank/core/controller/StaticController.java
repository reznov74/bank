package software.eng.project.bank.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class StaticController {
    @RequestMapping(value = "",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String test()
    {
        return "OK";
    }
}
