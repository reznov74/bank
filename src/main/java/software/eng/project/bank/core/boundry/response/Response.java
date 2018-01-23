package software.eng.project.bank.core.boundry.response;




public class Response {
    //TODO TIME THAT REQUEST BE READY SHOULD ADDED FOR ALL
     ResponseStatus responseStatus;

     long fallowUpNumber;

    public Response(ResponseStatus responseStatus, long fallowUpNumber) {
        this.responseStatus = responseStatus;
        this.fallowUpNumber = fallowUpNumber;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public long getFallowUpNumber() {
        return fallowUpNumber;
    }

    public void setFallowUpNumber(long fallowUpNumber) {
        this.fallowUpNumber = fallowUpNumber;
    }
    public Response(){

    }
}
