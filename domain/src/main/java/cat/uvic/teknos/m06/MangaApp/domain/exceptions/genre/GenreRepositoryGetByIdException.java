package cat.uvic.teknos.m06.MangaApp.domain.exceptions.genre;

public class GenreRepositoryGetByIdException extends RuntimeException{
    public GenreRepositoryGetByIdException() {
    }

    public GenreRepositoryGetByIdException(String message) {
        super(message);
    }

    public GenreRepositoryGetByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenreRepositoryGetByIdException(Throwable cause) {
        super(cause);
    }

    public GenreRepositoryGetByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
