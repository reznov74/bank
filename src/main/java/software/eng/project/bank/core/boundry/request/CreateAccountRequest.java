package software.eng.project.bank.core.boundry.request;


import software.eng.project.bank.core.model.Account.AccountType;

import java.sql.Date;
import java.sql.Timestamp;

public class CreateAccountRequest {
    AccountType type;
    long accountIDForInit;
    long barnchID;
    String confitionForGive;
    Date expireDateOfGive;
    Timestamp createTime;

    public CreateAccountRequest(AccountType type, long accountIDForInit, long barnchID, String confitionForGive, Date expireDateOfGive, Timestamp createTime) {
        this.type = type;
        this.accountIDForInit = accountIDForInit;
        this.barnchID = barnchID;
        this.confitionForGive = confitionForGive;
        this.expireDateOfGive = expireDateOfGive;
        this.createTime = createTime;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
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
}
