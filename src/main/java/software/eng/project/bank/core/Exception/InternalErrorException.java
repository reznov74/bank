/*
 * Copyright 2017 Vitamin Co. All Rights Reserved.
 */
package software.eng.project.bank.core.Exception;

import software.eng.project.bank.core.Exception.BankException;

public class InternalErrorException extends BankException
{
    public InternalErrorException()
    {
        super(ExceptionType.INTERNAL_SERVER_ERROR.name());
    }

    public InternalErrorException(Throwable cause)
    {
        super(ExceptionType.INTERNAL_SERVER_ERROR.name(), cause);
    }

    public InternalErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
