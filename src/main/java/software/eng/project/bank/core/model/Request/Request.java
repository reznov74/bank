package software.eng.project.bank.core.model.Request;

import software.eng.project.bank.core.model.Bank.Branch;
import software.eng.project.bank.core.model.Role.Customer;
import software.eng.project.bank.core.model.Role.Stuff;

import java.util.Date;

public class Request {
    Stuff stuff;
    Customer customer;
    Branch branch;
    Date requestDate;
    RequestStatus status;
}
