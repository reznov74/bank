package software.eng.project.bank.core.model.Account;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

enum CheckStatusType{
    PASS , REJECTED , NOT_USE
}
@Entity
@Table(name = "check")
public class Check {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
