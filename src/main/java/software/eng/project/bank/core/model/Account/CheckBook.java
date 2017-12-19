package software.eng.project.bank.core.model.Account;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.Date;

public class CheckBook {
    int checkBookNum;
    int countOfCheck;
    Date expireDate;
    Iterators.Array<Check> checks;
}
