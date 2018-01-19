package software.eng.project.bank.core.Exception;

public class BankException extends  Exception {
    public enum ExceptionType
    {
        INTERNAL_SERVER_ERROR, COOKIE_EXPIRD, LOGIN_FIALED, BAD_ARGUMENT, ZEPPELIN_SERVER,
    }
    public BankException()
    {
    }

    public BankException(String message)
    {
        super(message);
    }

    public BankException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BankException(Throwable cause)
    {
        super(cause);
    }

    public BankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
