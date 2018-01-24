package software.eng.project.bank.core.boundry.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AccountFlowType {
    PAYBILL , KHARID_INTERNET, KHARID_POZ
    , VARIZ_NAGHD ,VARIZ_SOOD , HAVALE_VARIZ , HAVALE_BARDASHT , PASS_CHECK
}