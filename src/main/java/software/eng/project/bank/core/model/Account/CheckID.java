package software.eng.project.bank.core.model.Account;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CheckID implements Serializable {
    @Column(name = "check_number", nullable = false)
    long checkNumber;
    @Column(name = "checkbook_number", nullable = false)
    long checkBookNumber;

    public long getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(long checkNumber) {
        this.checkNumber = checkNumber;
    }

    public long getCheckBookNumber() {
        return checkBookNumber;
    }

    public void setCheckBookNumber(long checkBookNumber) {
        this.checkBookNumber = checkBookNumber;
    }
}
