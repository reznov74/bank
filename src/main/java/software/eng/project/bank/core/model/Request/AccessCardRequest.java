package software.eng.project.bank.core.model.Request;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@DiscriminatorValue("1")
public class AccessCardRequest extends Request {

    @Column(name = "first")
    @NotNull
    boolean fristOrNot;

    public boolean isFristOrNot() {
        return fristOrNot;
    }

    public void setFristOrNot(boolean fristOrNot) {
        this.fristOrNot = fristOrNot;
    }

    @Override
    public String getType(){
        return "CARD";
    }
}
