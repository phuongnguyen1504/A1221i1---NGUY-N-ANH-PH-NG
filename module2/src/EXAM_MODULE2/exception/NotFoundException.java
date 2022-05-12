package EXAM_MODULE2.exception;

public class NotFoundException extends Exception{
    public NotFoundException(String message){
        super(message);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
