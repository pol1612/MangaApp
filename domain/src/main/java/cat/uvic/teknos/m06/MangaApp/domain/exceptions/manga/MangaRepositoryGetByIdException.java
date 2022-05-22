package cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga;

public class MangaRepositoryGetByIdException extends RuntimeException{
    public MangaRepositoryGetByIdException() {
    }

    public MangaRepositoryGetByIdException(String message) {
        super(message);
    }

    public MangaRepositoryGetByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public MangaRepositoryGetByIdException(Throwable cause) {
        super(cause);
    }

    public MangaRepositoryGetByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
