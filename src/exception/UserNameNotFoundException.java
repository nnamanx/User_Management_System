package exception;

public class UserNameNotFoundException extends Throwable{
    public UserNameNotFoundException() {
        super(ExceptionMessage.USERNAMENOTFOUND);
    }
}
