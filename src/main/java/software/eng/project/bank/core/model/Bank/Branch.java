package software.eng.project.bank.core.model.Bank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "end")
    @NotNull
    String address;
    @Column(name = "end")
    @NotNull
    int phone;
    @Column(name = "end")
    @NotNull
    String city;
    @Column(name = "end")
    @NotNull
    String city_;
    @Column(name = "end")
    @NotNull
    int barnchCode;

    public Branch(String address, int phone, String city, String city_, int barnchCode) {
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.city_ = city_;
        this.barnchCode = barnchCode;
    }
    @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_() {
        return city_;
    }

    public void setCity_(String city_) {
        this.city_ = city_;
    }

    public int getBarnchCode() {
        return barnchCode;
    }

    public void setBarnchCode(int barnchCode) {
        this.barnchCode = barnchCode;
    }
}
