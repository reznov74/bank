package software.eng.project.bank.core.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "type")
    @NotNull
    FaciltyType type;

    @Column(name = "amount")
    @NotNull
    double amount;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name= "account")
    Account account;

    @OneToMany(fetch = FetchType.EAGER )
    List<FacilityReturn> facilityReturn;
    public Facility(FaciltyType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FaciltyType getType() {
        return type;
    }

    public void setType(FaciltyType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<FacilityReturn> getFacilityReturn() {
        return facilityReturn;
    }

    public void setFacilityReturn(List<FacilityReturn> facilityReturn) {
        this.facilityReturn = facilityReturn;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
