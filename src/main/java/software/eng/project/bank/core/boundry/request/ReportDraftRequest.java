package software.eng.project.bank.core.boundry.request;

import java.util.Date;

enum MediaType{
    INTERNET , ATM
}
public class ReportDraftRequest {
    long acount;
    boolean giveOrPay;
    MediaType mediaType;
    Date startDate;
    Date endDate;

    public ReportDraftRequest(long acount, boolean giveOrPay, MediaType mediaType, Date startDate, Date endDate) {
        this.acount = acount;
        this.giveOrPay = giveOrPay;
        this.mediaType = mediaType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getAcount() {
        return acount;
    }

    public void setAcount(long acount) {
        this.acount = acount;
    }

    public boolean isGiveOrPay() {
        return giveOrPay;
    }

    public void setGiveOrPay(boolean giveOrPay) {
        this.giveOrPay = giveOrPay;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
