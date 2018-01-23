package software.eng.project.bank.core.model.Request;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "check_book_request")
public class CheckBookRequest extends Request{

    @Column(name = "number_of_check")
    @NotNull
    int numberOfCheck;

    public CheckBookRequest() {
    }

    public int getNumberOfCheck() {
        return numberOfCheck;
    }

    public void setNumberOfCheck(int numberOfCheck) {
        this.numberOfCheck = numberOfCheck;
    }
}
