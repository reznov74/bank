package software.eng.project.bank.core.boundry.request;


import software.eng.project.bank.core.model.Account.AccountType;
import software.eng.project.bank.core.model.Account.AccountTypeIndivisual;
import software.eng.project.bank.core.model.Account.AccountTypeReal;

import java.sql.Date;
import java.sql.Timestamp;

public class CreateAccountRequest {

    String nationalCodeCustomer;

    String accountNumberForInit;

    String conditionForGive;

    Date expireDateOfGive;

    java.util.Date createTime;

    int branchCode;

    double initCash;

    AccountTypeIndivisual accountTypeIndivisual;


    AccountTypeReal accountTypeReal;


    boolean withChek;


    AccountType accountType;

    public CreateAccountRequest(String accountIDForInit, String confitionForGive, Date expireDateOfGive, Timestamp createTime) {

        this.accountNumberForInit = accountIDForInit;
        this.conditionForGive = confitionForGive;
        this.expireDateOfGive = expireDateOfGive;
        this.createTime = createTime;
    }

    public CreateAccountRequest() {
    }

    public String getAccountNumberForInit() {
        return accountNumberForInit;
    }

    public void setAccountNumberForInit(String accountNumberForInit) {
        this.accountNumberForInit = accountNumberForInit;
    }

    public String getConditionForGive() {
        return conditionForGive;
    }

    public void setConditionForGive(String conditionForGive) {
        this.conditionForGive = conditionForGive;
    }

    public Date getExpireDateOfGive() {
        return expireDateOfGive;
    }

    public void setExpireDateOfGive(Date expireDateOfGive) {
        this.expireDateOfGive = expireDateOfGive;
    }

    public java.util.Date getCreateTime() {
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

    public double getInitCash() {
        return initCash;
    }

    public void setInitCash(double initCash) {
        this.initCash = initCash;
    }

    public String getNationalCodeCustomer() {
        return nationalCodeCustomer;
    }

    public void setNationalCodeCustomer(String nationalCodeCustomer) {
        this.nationalCodeCustomer = nationalCodeCustomer;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }
}
