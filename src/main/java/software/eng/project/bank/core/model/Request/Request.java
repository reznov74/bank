package software.eng.project.bank.core.model.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Role.Customer;
import software.eng.project.bank.core.model.Role.Stuff;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@MappedSuperclass
public abstract class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "stuff")
    //@Column(name = "stuff")
    @NotNull
    Stuff stuff;
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer")
    //@Column(name = "customer")
    @NotNull
    Customer customer;
    @OneToOne(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "branch")
    //@Column(name = "branch")
    @NotNull
    Branch branch;
    @Column(name = "date")
    @NotNull
    Date requestDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull
    RequestStatus status;

    public Request(Stuff stuff, Customer customer, Branch branch, Date requestDate, RequestStatus status) {
        this.stuff = stuff;
        this.customer = customer;
        this.branch = branch;
        this.requestDate = requestDate;
        this.status = status;
    }

    public Request() {
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
