package cat.uvic.teknos.m06.MangaApp.domain.exceptions;

public class CoverrepositoryDeleteException extends RuntimeException{
    public CoverrepositoryDeleteException() {
    }

    public CoverrepositoryDeleteException(String message) {
        super(message);
    }

    public CoverrepositoryDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoverrepositoryDeleteException(Throwable cause) {
        super(cause);
    }

    public CoverrepositoryDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
