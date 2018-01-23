package software.eng.project.bank.core.boundry.request;


import java.sql.Date;

public class CreateResponseRequest {

    long requestID;

    boolean isAccept;

    Date answerTime;

    String forWhy;

    int dayForReady;

    public CreateResponseRequest() {
    }

    public int getDayForReady() {
        return dayForReady;
    }

    public void setDayForReady(int dayForReady) {
        this.dayForReady = dayForReady;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public String getForWhy() {
        return forWhy;
    }

    public void setForWhy(String forWhy) {
        this.forWhy = forWhy;
    }
}
