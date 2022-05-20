package cat.uvic.teknos.m06.MangaApp.domain.exceptions;

public class CoverRepositoryDeleteException extends RuntimeException{
    public CoverRepositoryDeleteException() {
    }

    public CoverRepositoryDeleteException(String message) {
        super(message);
    }

    public CoverRepositoryDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoverRepositoryDeleteException(Throwable cause) {
        super(cause);
    }

    public CoverRepositoryDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
