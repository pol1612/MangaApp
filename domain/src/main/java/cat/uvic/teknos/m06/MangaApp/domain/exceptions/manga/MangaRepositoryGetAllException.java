package cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga;

public class MangaRepositoryGetAllException extends RuntimeException{
    public MangaRepositoryGetAllException() {
    }

    public MangaRepositoryGetAllException(String message) {
        super(message);
    }

    public MangaRepositoryGetAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public MangaRepositoryGetAllException(Throwable cause) {
        super(cause);
    }

    public MangaRepositoryGetAllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
