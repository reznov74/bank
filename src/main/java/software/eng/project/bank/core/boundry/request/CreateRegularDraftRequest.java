package software.eng.project.bank.core.boundry.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import software.eng.project.bank.core.model.Account.Account;
import software.eng.project.bank.core.model.Account.DraftType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateRegularDraftRequest {

    long sourceAccount;

    long distAccount;

    double amount;

    String fowWhy;


    Date startReturnDate;

    Date periodDate;

    Date endReturnDate;

    TypeOfConfirme typeOfConfirme;

    public CreateRegularDraftRequest(long sourceAccount, long distAccount, double amount, String fowWhy, Date startReturnDate, Date periodDate, Date endReturnDate, TypeOfConfirme typeOfConfirme) {
        this.sourceAccount = sourceAccount;
        this.distAccount = distAccount;
        this.amount = amount;
        this.fowWhy = fowWhy;
        this.startReturnDate = startReturnDate;
        this.periodDate = periodDate;
        this.endReturnDate = endReturnDate;
        this.typeOfConfirme = typeOfConfirme;
    }

    public long getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public long getDistAccount() {
        return distAccount;
    }

    public void setDistAccount(long distAccount) {
        this.distAccount = distAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFowWhy() {
        return fowWhy;
    }

    public void setFowWhy(String fowWhy) {
        this.fowWhy = fowWhy;
    }

    public Date getStartReturnDate() {
        return startReturnDate;
    }

    public void setStartReturnDate(Date startReturnDate) {
        this.startReturnDate = startReturnDate;
    }

    public Date getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(Date periodDate) {
        this.periodDate = periodDate;
    }

    public Date getEndReturnDate() {
        return endReturnDate;
    }

    public void setEndReturnDate(Date endReturnDate) {
        this.endReturnDate = endReturnDate;
    }

    public TypeOfConfirme getTypeOfConfirme() {
        return typeOfConfirme;
    }

    public void setTypeOfConfirme(TypeOfConfirme typeOfConfirme) {
        this.typeOfConfirme = typeOfConfirme;
    }
}
