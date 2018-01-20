package software.eng.project.bank.core.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Draft implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
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
    Timestamp draftedDate;
    @Column(name = "amount")
    @NotNull
    double amount;
    @Column(name = "for" , length = 1000)
    String fowWhy;
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull
    DraftType draftType;
    @JsonIgnore
    @Column(name = "max_amount")
    @NotNull
    float maxAmount;

    public Draft(Account sourceAccount, Account distAccount, Timestamp draftedDate, double amount, String fowWhy, DraftType draftType, float maxAmount) {
        this.sourceAccount = sourceAccount;
        this.distAccount = distAccount;
        this.draftedDate = draftedDate;
        this.amount = amount;
        this.fowWhy = fowWhy;
        this.draftType = draftType;
        this.maxAmount = maxAmount;
    }

    public Draft() {
    }

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

    public Timestamp getDraftedDate() {
        return draftedDate;
    }

    public void setDraftedDate(Timestamp draftedDate) {
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

    public float getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(float maxAmount) {
        this.maxAmount = maxAmount;
    }
}
