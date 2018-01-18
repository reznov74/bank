package software.eng.project.bank.core.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "draft")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Draft {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "source")
    @NotNull
    Account sourceAccount;
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "dist")
    @NotNull
    Account distAccount;
    @Column(name = "date")
    @NotNull
    Date draftedDate;
    @Column(name = "amount")
    @NotNull
    double amount;
    @Column(name = "for" , length = 1000)
    String fowWhy;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull
    DraftType draftType;
    @Column(name = "max_amount")
    @NotNull
    float maxAmount;
}
