package pt.amane.condominium_fee.services.exception;

public class DataResourceAccessException extends RuntimeException{

    private static final long serialVersioUID = 1L;

    public DataResourceAccessException(String message) {
        super(message);
    }

    public DataResourceAccessException(Throwable cause) {
        super(cause);
    }
}
