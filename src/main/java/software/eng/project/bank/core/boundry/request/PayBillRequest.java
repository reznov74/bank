package software.eng.project.bank.core.boundry.request;

import java.util.List;

enum TypeOfBill{
    IRANCELL , BARGH , GAZ , AB
}
public class PayBillRequest {
    List<TypeOfBill> typeOfBill;
    List<Integer> billID;
    List<Integer> payID;
    long account;

    public PayBillRequest(List<TypeOfBill> typeOfBill, List<Integer> billID, List<Integer> payID, long account) {
        this.typeOfBill = typeOfBill;
        this.billID = billID;
        this.payID = payID;
        this.account = account;
    }

    public List<TypeOfBill> getTypeOfBill() {
        return typeOfBill;
    }

    public void setTypeOfBill(List<TypeOfBill> typeOfBill) {
        this.typeOfBill = typeOfBill;
    }

    public List<Integer> getBillID() {
        return billID;
    }

    public void setBillID(List<Integer> billID) {
        this.billID = billID;
    }

    public List<Integer> getPayID() {
        return payID;
    }

    public void setPayID(List<Integer> payID) {
        this.payID = payID;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }
}
