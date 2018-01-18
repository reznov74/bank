package software.eng.project.bank.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.repository.AccountRepository;
import software.eng.project.bank.security.JwtTokenUtil;

import java.util.List;

@Service
public class UserService {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountList (){
        return this.accountRepository.findAll();
    }

}
