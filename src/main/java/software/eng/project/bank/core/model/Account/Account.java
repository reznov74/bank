package software.eng.project.bank.core.model.Account;

import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Role.Stuff;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "account_id", length = 100)
    @NotNull
    @Size(min = 1, max = 100)
    private long accountNumber;

    float cash;

    Date expireDate;
    Date StartDate;

    AccountType accountType;

    AccountStatus accountStatus;

    CheckBook checkBook;

    Branch createBranch;

    Stuff createStuff;



}