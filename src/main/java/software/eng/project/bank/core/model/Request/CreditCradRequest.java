package software.eng.project.bank.core.model.Request;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

enum CreditCardType{}
@Entity
@Table(name = "card_req")
public class CreditCradRequest extends Request{
    @Column(name = "type")
    @NotNull
    @Enumerated(EnumType.STRING)
    CreditCardType type;
    @Column(name = "frist")
    @NotNull
    boolean fristOrNot;
    @Column(name = "init")
    @NotNull
    double initCash;

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    public boolean isFristOrNot() {
        return fristOrNot;
    }

    public void setFristOrNot(boolean fristOrNot) {
        this.fristOrNot = fristOrNot;
    }

    public double getInitCash() {
        return initCash;
    }

    public void setInitCash(double initCash) {
        this.initCash = initCash;
    }
}
