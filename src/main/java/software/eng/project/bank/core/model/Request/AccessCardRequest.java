package software.eng.project.bank.core.model.Request;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "card_req")
public class AccessCardRequest extends Request{

    @Column(name = "first")
    @NotNull
    boolean fristOrNot;

    public boolean isFristOrNot() {
        return fristOrNot;
    }

    public void setFristOrNot(boolean fristOrNot) {
        this.fristOrNot = fristOrNot;
    }

}
