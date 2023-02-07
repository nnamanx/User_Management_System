package exception;

public class ListIsEmpty extends Throwable {
    public ListIsEmpty() {
        super(ExceptionMessage.LISTISEMPTY);
    }
}
