package software.eng.project.bank.core.service;

import org.springframework.stereotype.Service;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Account.Check;
import software.eng.project.bank.core.model.Request.Request;
import software.eng.project.bank.core.model.Response.RequestResponse;

import java.util.List;

@Service
public class StuffService {
    public List<Request> getRequests(){
        return null;
    }
    public Request getRequest(long requestID){
        return null;
    }
    public String answerRequest(RequestResponse requestResponse){
        return null;
    }
    public String redirectRequest(long requestID, long userID){
        return null;
    }
    public String createAccount(Account account){
        return  null;
    }
    public String passCheck(Check check){
        return null;
    }
}
