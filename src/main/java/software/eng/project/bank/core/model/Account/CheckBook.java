package software.eng.project.bank.core.model.Account;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "checkbook")
public class CheckBook {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number")
    @NotNull
    int checkBookNum;
    @Column(name = "count")
    @NotNull
    int countOfCheck;
    @Column(name = "expire")
    @NotNull
    Date expireDate;
    @OneToMany(fetch= FetchType.EAGER , cascade = {CascadeType.ALL})
    @JoinColumn(name = "check_number")
    @Column(name = "checks")
    @NotNull
    Iterators.Array<Check> checks;

    public CheckBook(int checkBookNum, int countOfCheck, Date expireDate, Iterators.Array<Check> checks) {
        this.checkBookNum = checkBookNum;
        this.countOfCheck = countOfCheck;
        this.expireDate = expireDate;
        this.checks = checks;
    }

    public int getCheckBookNum() {
        return checkBookNum;
    }

    public void setCheckBookNum(int checkBookNum) {
        this.checkBookNum = checkBookNum;
    }

    public int getCountOfCheck() {
        return countOfCheck;
    }

    public void setCountOfCheck(int countOfCheck) {
        this.countOfCheck = countOfCheck;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Iterators.Array<Check> getChecks() {
        return checks;
    }

    public void setChecks(Iterators.Array<Check> checks) {
        this.checks = checks;
    }
}
