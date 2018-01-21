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

@Service
public class AdminService {
    @Autowired
    private StuffRepository stuffRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;
    public User addUser(User user) throws BadArgumentException {
        if(user instanceof Stuff){

        }else if(user instanceof Customer){

        }else if(user instanceof Admin){

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
