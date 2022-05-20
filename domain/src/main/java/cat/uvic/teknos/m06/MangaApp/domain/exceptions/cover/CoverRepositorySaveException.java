package cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover;

public class CoverRepositorySaveException extends RuntimeException{
    public CoverRepositorySaveException() {
    }

    public CoverRepositorySaveException(String message) {
        super(message);
    }

    public CoverRepositorySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoverRepositorySaveException(Throwable cause) {
        super(cause);
    }

    public CoverRepositorySaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
