package software.eng.project.bank.core.boundry.request;


import software.eng.project.bank.core.model.Account.AccountType;
import software.eng.project.bank.core.model.Account.AccountTypeIndivisual;
import software.eng.project.bank.core.model.Account.AccountTypeReal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Date;
import java.sql.Timestamp;

public class CreateAccountRequest {

    long userID;

    long accountIDForInit;

    long barnchID;

    String confitionForGive;

    Date expireDateOfGive;

    Timestamp createTime;

    float initCash;

    AccountTypeIndivisual accountTypeIndivisual;


    AccountTypeReal accountTypeReal;


    boolean withChek;


    AccountType accountType;

    public CreateAccountRequest( long accountIDForInit, long barnchID, String confitionForGive, Date expireDateOfGive, Timestamp createTime) {

        this.accountIDForInit = accountIDForInit;
        this.barnchID = barnchID;
        this.confitionForGive = confitionForGive;
        this.expireDateOfGive = expireDateOfGive;
        this.createTime = createTime;
    }

    public CreateAccountRequest() {
    }

    public long getAccountIDForInit() {
        return accountIDForInit;
    }

    public void setAccountIDForInit(long accountIDForInit) {
        this.accountIDForInit = accountIDForInit;
    }

    public long getBarnchID() {
        return barnchID;
    }

    public void setBarnchID(long barnchID) {
        this.barnchID = barnchID;
    }

    public String getConfitionForGive() {
        return confitionForGive;
    }

    public void setConfitionForGive(String confitionForGive) {
        this.confitionForGive = confitionForGive;
    }

    public Date getExpireDateOfGive() {
        return expireDateOfGive;
    }

    public void setExpireDateOfGive(Date expireDateOfGive) {
        this.expireDateOfGive = expireDateOfGive;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public AccountTypeIndivisual getAccountTypeIndivisual() {
        return accountTypeIndivisual;
    }

    public void setAccountTypeIndivisual(AccountTypeIndivisual accountTypeIndivisual) {
        this.accountTypeIndivisual = accountTypeIndivisual;
    }

    public AccountTypeReal getAccountTypeReal() {
        return accountTypeReal;
    }

    public void setAccountTypeReal(AccountTypeReal accountTypeReal) {
        this.accountTypeReal = accountTypeReal;
    }

    public boolean isWithChek() {
        return withChek;
    }

    public void setWithChek(boolean withChek) {
        this.withChek = withChek;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public float getInitCash() {
        return initCash;
    }

    public void setInitCash(float initCash) {
        this.initCash = initCash;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
