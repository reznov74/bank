/*
 * Copyright 2017 Vitamin Co. All Rights Reserved.
 */
package software.eng.project.bank.core.Exception;

import software.eng.project.bank.core.Exception.BankException;

public class BadArgumentException extends BankException
{
    public BadArgumentException()
    {
        super(ExceptionType.BAD_ARGUMENT.name());
    }

    public BadArgumentException(Throwable cause)
    {
        super(ExceptionType.BAD_ARGUMENT.name(), cause);
    }

    public BadArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
