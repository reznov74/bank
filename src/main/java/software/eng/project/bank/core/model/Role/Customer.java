package software.eng.project.bank.core.model.Role;

import software.eng.project.bank.core.model.Account.Account;

import javax.persistence.*;

@Entity
public class Customer extends User{
    @OneToMany
    Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
