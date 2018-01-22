package software.eng.project.bank.core.model.Account;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CheckID implements Serializable {
    @Column(name = "check_id", nullable = false)
    long chechID;
    @Column(name = "checkbook_id", nullable = false)
    long checkBookID;

    public long getChechID() {
        return chechID;
    }

    public void setChechID(long chechID) {
        this.chechID = chechID;
    }

    public long getCheckBookID() {
        return checkBookID;
    }

    public void setCheckBookID(long checkBookID) {
        this.checkBookID = checkBookID;
    }
}
