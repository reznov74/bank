package software.eng.project.bank.core.model.Request;

import software.eng.project.bank.core.model.Account.FacilityRequestType;

public class FacilityRequest extends Request {
    FacilityRequestType type;
    String title;
    String cashType;
    String typeOfGranty;
}
