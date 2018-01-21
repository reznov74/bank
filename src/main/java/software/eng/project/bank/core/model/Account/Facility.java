package software.eng.project.bank.core.model.Account;

import software.eng.project.bank.core.model.Role.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "facility")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @ManyToOne(fetch = FetchType.EAGER ,cascade = {CascadeType.ALL})
    @JoinColumn
    Customer customer;

    @OneToMany(fetch = FetchType.EAGER ,cascade = {CascadeType.ALL})
    @JoinColumn
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
