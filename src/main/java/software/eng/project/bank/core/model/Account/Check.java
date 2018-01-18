package software.eng.project.bank.core.model.Account;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

enum CheckStatusType{
    PASS , REJECTED , NOT_USE
}
@Entity
@Table(name = "check")
public class Check {
    @Column(name = "number")
    @NotNull
    int checkNum;
    @Column(name = "amount")
    @NotNull
    double checkAmount;
    @Column(name = "date")
    @NotNull
    Date CheckDate;
    @Column(name = "status")
    @NotNull
    CheckStatusType status;

}
