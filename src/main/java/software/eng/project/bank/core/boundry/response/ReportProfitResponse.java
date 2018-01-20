package software.eng.project.bank.core.boundry.response;

import software.eng.project.bank.core.model.Account.Account;

import java.time.Month;

public class ReportProfitResponse {
    Month month;
    float amount;
    float percent;
    Account account;

    public ReportProfitResponse(Month month, float amount, float percent, Account account) {
        this.month = month;
        this.amount = amount;
        this.percent = percent;
        this.account = account;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
