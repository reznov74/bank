package software.eng.project.bank.core.boundry.request;

import software.eng.project.bank.core.model.Account.CashType;
import software.eng.project.bank.core.model.Account.TypeOfFacility;
import software.eng.project.bank.core.model.Account.WarantyTypeFacility;




public class CreateFacilityRequest {
    long branchID;
    float amount;
    int timeOfFacility;
    boolean isDayOrMounth;
    TypeOfFacility typeOfFacility;
    CashType cashType;
    WarantyTypeFacility warantyType;

    public CreateFacilityRequest(long branchID, float amount, int timeOfFacility, boolean isDayOrMounth, TypeOfFacility typeOfFacility, CashType cashType, WarantyTypeFacility warantyType) {
        this.branchID = branchID;
        this.amount = amount;
        this.timeOfFacility = timeOfFacility;
        this.isDayOrMounth = isDayOrMounth;
        this.typeOfFacility = typeOfFacility;
        this.cashType = cashType;
        this.warantyType = warantyType;
    }

    public long getBranchID() {
        return branchID;
    }

    public void setBranchID(long branchID) {
        this.branchID = branchID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getTimeOfFacility() {
        return timeOfFacility;
    }

    public void setTimeOfFacility(int timeOfFacility) {
        this.timeOfFacility = timeOfFacility;
    }

    public boolean isDayOrMounth() {
        return isDayOrMounth;
    }

    public void setDayOrMounth(boolean dayOrMounth) {
        isDayOrMounth = dayOrMounth;
    }

    public TypeOfFacility getTypeOfFacility() {
        return typeOfFacility;
    }

    public void setTypeOfFacility(TypeOfFacility typeOfFacility) {
        this.typeOfFacility = typeOfFacility;
    }

    public CashType getCashType() {
        return cashType;
    }

    public void setCashType(CashType cashType) {
        this.cashType = cashType;
    }

    public WarantyTypeFacility getWarantyType() {
        return warantyType;
    }

    public void setWarantyType(WarantyTypeFacility warantyType) {
        this.warantyType = warantyType;
    }
}

