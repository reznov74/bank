package software.eng.project.bank.core.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "draft")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Draft {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id")
    @Column(name = "source")
    @NotNull
    Account sourceAccount;
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id")
    @Column(name = "dist")
    @NotNull
    Account distAccount;
    @Column(name = "date")
    @NotNull
    Date draftedDate;
    @Column(name = "amount")
    @NotNull
    double amount;
    @Column(name = "dist" , length = 1000)
    String fowWhy;
    @Column(name = "type")
    @NotNull
    DraftType draftType;
    @Column(name = "max_amount")
    @NotNull
    float maxAmount;
}
