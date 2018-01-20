/*
 * Copyright 2017 Vitamin Co. All Rights Reserved.
 */
package software.eng.project.bank.core.Exception;

import software.eng.project.bank.core.Exception.BankException;

public class ServerErrorException extends BankException
{
    public ServerErrorException()
    {
        super(ExceptionType.ZEPPELIN_SERVER.name());
    }

    public ServerErrorException(Throwable cause)
    {
        super(ExceptionType.ZEPPELIN_SERVER.name(), cause);
    }

    public ServerErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
