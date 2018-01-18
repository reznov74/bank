package software.eng.project.bank.core.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "return_facility")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class FacilityReturn {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "facility")
    @NotNull
    Facility facility;
    @Column(name = "amount")
    @NotNull
    double amount;
    @Column(name = "resid_number")
    @NotNull
    int residNum;

    public FacilityReturn(Facility facility, double amount, int residNum) {
        this.facility = facility;
        this.amount = amount;
        this.residNum = residNum;
    }
    @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getResidNum() {
        return residNum;
    }

    public void setResidNum(int residNum) {
        this.residNum = residNum;
    }
}
