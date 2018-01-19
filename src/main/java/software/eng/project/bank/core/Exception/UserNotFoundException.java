package software.eng.project.bank.core.Exception;



public class UserNotFoundException extends Exception {
    public UserNotFoundException()
    {
        super(BankException.ExceptionType.LOGIN_FIALED.name());
    }

    public UserNotFoundException(Throwable cause)
    {
        super(BankException.ExceptionType.LOGIN_FIALED.name(), cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
