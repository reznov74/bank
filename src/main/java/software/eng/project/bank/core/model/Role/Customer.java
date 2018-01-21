package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.model.Account.Account;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends User{
    @OneToMany
    List<Account> account;

    public Customer(User user) {
        super(user);
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
