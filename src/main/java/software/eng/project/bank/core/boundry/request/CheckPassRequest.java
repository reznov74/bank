package software.eng.project.bank.core.boundry.request;

public class CheckPassRequest {

    long checkID;
    long checkBookID;
    double cash;
    String toName;

    public long getCheckID() {
        return checkID;
    }

    public void setCheckID(long checkID) {
        this.checkID = checkID;
    }

    public long getCheckBookID() {
        return checkBookID;
    }

    public void setCheckBookID(long checkBookID) {
        this.checkBookID = checkBookID;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}
