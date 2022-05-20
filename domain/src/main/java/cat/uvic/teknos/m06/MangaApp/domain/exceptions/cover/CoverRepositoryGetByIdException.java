package cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover;

public class CoverRepositoryGetByIdException extends RuntimeException{
    public CoverRepositoryGetByIdException() {
    }

    public CoverRepositoryGetByIdException(String message) {
        super(message);
    }

    public CoverRepositoryGetByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoverRepositoryGetByIdException(Throwable cause) {
        super(cause);
    }

    public CoverRepositoryGetByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
