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
    FacilityRequestType type;
    @Column(name = "title")
    @NotNull
    String title;
    @Column(name = "cash_type" , length = 1000)
    @NotNull
    String cashType;
    @Column(name = "garanty_type", length = 1000)
    @NotNull
    String grantyType;

    public FaciltyType(FacilityRequestType type, String title, String cashType, String grantyType) {
        this.type = type;
        this.title = title;
        this.cashType = cashType;
        this.grantyType = grantyType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getGrantyType() {
        return grantyType;
    }

    public void setGrantyType(String grantyType) {
        this.grantyType = grantyType;
    }
}
