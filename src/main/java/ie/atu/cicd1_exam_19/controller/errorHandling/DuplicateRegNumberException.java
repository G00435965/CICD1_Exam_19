package ie.atu.cicd1_exam_19.controller.errorHandling;

public class DuplicateRegNumberException extends RuntimeException {
    private String message;
    private String field;
    public DuplicateRegNumberException(String field, String message)
    {
        this.field = field;
    }
    public DuplicateRegNumberException(String message)
    {
        super(message);
    }
}
