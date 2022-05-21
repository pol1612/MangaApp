package cat.uvic.teknos.m06.MangaApp.domain.exceptions.genre;

public class GenreRepositoryGetAllException extends RuntimeException{
    public GenreRepositoryGetAllException() {
    }

    public GenreRepositoryGetAllException(String message) {
        super(message);
    }

    public GenreRepositoryGetAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenreRepositoryGetAllException(Throwable cause) {
        super(cause);
    }

    public GenreRepositoryGetAllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
