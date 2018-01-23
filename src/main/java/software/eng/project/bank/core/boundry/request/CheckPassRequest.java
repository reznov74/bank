package software.eng.project.bank.core.boundry.request;

public class CheckPassRequest {

    long checkNumber;
    long checkBookNumber;
    double cash;
    String toName;

    public long getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(long checkNumber) {
        this.checkNumber = checkNumber;
    }

    public long getCheckBookNumber() {
        return checkBookNumber;
    }

    public void setCheckBookNumber(long checkBookNumber) {
        this.checkBookNumber = checkBookNumber;
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
