package cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga;

public class MangaRepositorySaveException extends RuntimeException{
    public MangaRepositorySaveException() {
    }

    public MangaRepositorySaveException(String message) {
        super(message);
    }

    public MangaRepositorySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public MangaRepositorySaveException(Throwable cause) {
        super(cause);
    }

    public MangaRepositorySaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
