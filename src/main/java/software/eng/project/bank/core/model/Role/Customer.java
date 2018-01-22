package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.boundry.request.CreateUserRequest;
import software.eng.project.bank.core.model.Account.Account;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class Customer extends UserModel {
    @OneToMany
    List<Account> account;

    public Customer(){

    }
    public Customer(CreateUserRequest user) {
        super(user);
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
