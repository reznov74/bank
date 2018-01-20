/*
 * Copyright 2017 Vitamin Co. All Rights Reserved.
 */
package software.eng.project.bank.core.Exception;

import software.eng.project.bank.core.Exception.BankException;

public class CookieExpiredException extends BankException
{
    public CookieExpiredException()
    {
        super(ExceptionType.COOKIE_EXPIRD.name());
    }

    public CookieExpiredException(Throwable cause)
    {
        super(ExceptionType.COOKIE_EXPIRD.name(), cause);
    }

    public CookieExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
