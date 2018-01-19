package software.eng.project.bank.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.eng.project.bank.core.Exception.UserNotFoundException;
import software.eng.project.bank.core.domin.request.PayBillRequest;
import software.eng.project.bank.core.domin.response.PayBillResponse;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Account.AccountFlow;
import software.eng.project.bank.core.repository.AccountRepository;
import software.eng.project.bank.security.JwtTokenUtil;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountList () throws UserNotFoundException {
        return this.accountRepository.findAll();
    }
    public List<AccountFlow> getAccountFlow() {
        return null;
    }
    public ResponseEntity<InputStreamResource> getReceiveAccountFlow(){
        return null;
    }
    public PayBillResponse payBill(PayBillRequest payBillRequest){
        return null;
    }

}
