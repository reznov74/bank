package software.eng.project.bank.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.eng.project.bank.core.Exception.BadArgumentException;
import software.eng.project.bank.core.model.Role.Admin;
import software.eng.project.bank.core.model.Role.Customer;
import software.eng.project.bank.core.model.Role.Stuff;
import software.eng.project.bank.core.model.Role.User;
import software.eng.project.bank.core.repository.AdminRepository;
import software.eng.project.bank.core.repository.CustomerRepository;
import software.eng.project.bank.core.repository.StuffRepository;
import software.eng.project.bank.security.model.Authority;
import software.eng.project.bank.security.model.AuthorityName;
import software.eng.project.bank.security.repository.AuthorityRepository;
import software.eng.project.bank.security.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    private static long AUTHORITY_ADMIN=2;
    private static long AUTHORITY_CUSTOMER=1;
    private static long AUTHORITY_STUFF=3;
    private static String PASSWORD="$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi";
    @Autowired
    private StuffRepository stuffRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;


    public User addUser(User user,long adminID) throws BadArgumentException {
        if(user.getAuthorityName().equals(AuthorityName.ROLE_ADMIN)){
            Admin admin = new Admin(user);
            User user2=this.adminRepository.save(admin);
            software.eng.project.bank.security.model.User user1 =new software.eng.project.bank.security.model.User();
            List<Authority> authorities =new ArrayList<>();
            Authority authority=this.authorityRepository.findById(AUTHORITY_ADMIN);
            authorities.add(authority);
            user1.setPassword(PASSWORD);
            user1.setAuthorities(authorities);
            user1.setUsername(user.getUsername());
            user1.setEnabled(true);
            user1.setUser(user2);
            this.userRepository.save(user1);
        }else if(user.getAuthorityName().equals(AuthorityName.ROLE_STUFF)){
            Stuff stuff = new Stuff(user);
            User user2=this.stuffRepository.save(stuff);
            software.eng.project.bank.security.model.User user1 =new software.eng.project.bank.security.model.User();
            List<Authority> authorities =new ArrayList<>();
            Authority authority=this.authorityRepository.findById(AUTHORITY_STUFF);
            authorities.add(authority);
            user1.setPassword(PASSWORD);
            user1.setAuthorities(authorities);
            user1.setUsername(user.getUsername());
            user1.setEnabled(true);
            user1.setUser(user2);
            this.userRepository.save(user1);

        }else if(user.getAuthorityName().equals(AuthorityName.ROLE_USER)){
            Customer customer = new Customer(user);
            User user2=this.customerRepository.save(customer);
            software.eng.project.bank.security.model.User user1 =new software.eng.project.bank.security.model.User();
            List<Authority> authorities =new ArrayList<>();
            Authority authority=this.authorityRepository.findById(AUTHORITY_CUSTOMER);
            authorities.add(authority);
            user1.setPassword(PASSWORD);
            user1.setAuthorities(authorities);
            user1.setUsername(user.getUsername());
            user1.setEnabled(true);
            user1.setUser(user2);
            this.userRepository.save(user1);
        }
        else{
            throw new BadArgumentException();
        }
        return null;
    }
    public User removeUser(long userID){
        return null;
    }
    public User changeUser(User user){
        return null;
    }
    public String getLog(){
        return null;
    }
}
