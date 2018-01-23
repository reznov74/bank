package software.eng.project.bank.core.model.Request;

import software.eng.project.bank.core.model.Account.CashType;

import software.eng.project.bank.core.model.Account.TypeOfFacility;
import software.eng.project.bank.core.model.Account.WarantyTypeFacility;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "facility_req")
public class FacilityRequest extends Request {



    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    @NotNull
    TypeOfFacility title;

    @Enumerated(EnumType.STRING)
    @Column(name = "cash")
    @NotNull
    CashType cashType;

    @Enumerated(EnumType.STRING)
    @Column(name = "waranty")
    @NotNull
    WarantyTypeFacility typeOfWaranty;


    public TypeOfFacility getTitle() {
        return title;
    }

    public void setTitle(TypeOfFacility title) {
        this.title = title;
    }

    public CashType getCashType() {
        return cashType;
    }

    public void setCashType(CashType cashType) {
        this.cashType = cashType;
    }

    public WarantyTypeFacility getTypeOfGranty() {
        return typeOfWaranty;
    }

    public void setTypeOfGranty(WarantyTypeFacility typeOfGranty) {
        this.typeOfWaranty = typeOfGranty;
    }
}
