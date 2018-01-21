package software.eng.project.bank.core.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "facility_type")
public class FaciltyType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "request_type")
    @NotNull
    TypeOfFacility type;

    @Column(name = "cash_type" , length = 1000)
    @NotNull
    @Enumerated
    CashType cashType;

    @Column(name = "garanty_type", length = 1000)
    @NotNull
    @Enumerated
    WarantyTypeFacility grantyType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeOfFacility getType() {
        return type;
    }

    public void setType(TypeOfFacility type) {
        this.type = type;
    }

    public CashType getCashType() {
        return cashType;
    }

    public void setCashType(CashType cashType) {
        this.cashType = cashType;
    }

    public WarantyTypeFacility getGrantyType() {
        return grantyType;
    }

    public void setGrantyType(WarantyTypeFacility grantyType) {
        this.grantyType = grantyType;
    }
}
