/*
 * Copyright 2017 Vitamin Co. All Rights Reserved.
 */
package software.eng.project.bank.core.Exception;

import software.eng.project.bank.core.Exception.BankException;

public class ServerErrorException extends BankException
{
    public ServerErrorException()
    {
        super(ExceptionType.BANK_EXCEPTON.name());
    }

    public ServerErrorException(Throwable cause)
    {
        super(ExceptionType.BANK_EXCEPTON.name(), cause);
    }

    public ServerErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
