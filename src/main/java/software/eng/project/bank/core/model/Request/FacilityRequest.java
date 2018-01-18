package software.eng.project.bank.core.model.Request;

import software.eng.project.bank.core.model.Account.FacilityRequestType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "facility_req")
public class FacilityRequest extends Request {

    @Column(name = "type")
    @NotNull
    @Enumerated(EnumType.STRING)
    FacilityRequestType type;
    @Column(name = "title")
    @NotNull
    String title;
    @Column(name = "cash")
    @NotNull
    String cashType;
    @Column(name = "garanty")
    @NotNull
    String typeOfGranty;

    public FacilityRequestType getType() {
        return type;
    }

    public void setType(FacilityRequestType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCashType() {
        return cashType;
    }

    public void setCashType(String cashType) {
        this.cashType = cashType;
    }

    public String getTypeOfGranty() {
        return typeOfGranty;
    }

    public void setTypeOfGranty(String typeOfGranty) {
        this.typeOfGranty = typeOfGranty;
    }
}
