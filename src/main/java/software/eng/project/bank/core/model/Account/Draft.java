package software.eng.project.bank.core.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "draft")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Draft {
    //public static double MAX_AMOUNT = 1000000000;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
     long id;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "source")
    @NotNull
    Account sourceAccount;

    @OneToOne(fetch= FetchType.LAZY )
    @JoinColumn(name = "dist")
    @NotNull
    Account distAccount;

    @Column(name = "date")
    @NotNull
    java.util.Date draftedDate;

    @Column(name = "amount")
    @NotNull
    double amount;

    @Column(name = "for_" , length = 1000)
    String fowWhy;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull
    DraftType draftType;



    public Draft(Account sourceAccount, Account distAccount, java.sql.Date draftedDate, double amount, String fowWhy, DraftType draftType) {
        this.sourceAccount = sourceAccount;
        this.distAccount = distAccount;
        this.draftedDate = draftedDate;
        this.amount = amount;
        this.fowWhy = fowWhy;
        this.draftType = draftType;
    }

    public Draft() {
    }

    @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDistAccount() {
        return distAccount;
    }

    public void setDistAccount(Account distAccount) {
        this.distAccount = distAccount;
    }

    public java.util.Date getDraftedDate() {
        return draftedDate;
    }

    public void setDraftedDate(Date draftedDate) {
        this.draftedDate = draftedDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFowWhy() {
        return fowWhy;
    }

    public void setFowWhy(String fowWhy) {
        this.fowWhy = fowWhy;
    }

    public DraftType getDraftType() {
        return draftType;
    }

    public void setDraftType(DraftType draftType) {
        this.draftType = draftType;
    }

}
