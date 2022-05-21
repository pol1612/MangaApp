package cat.uvic.teknos.m06.MangaApp.domain.exceptions.genre;

public class GenreRepositorySaveException extends RuntimeException{
    public GenreRepositorySaveException() {
    }

    public GenreRepositorySaveException(String message) {
        super(message);
    }

    public GenreRepositorySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenreRepositorySaveException(Throwable cause) {
        super(cause);
    }

    public GenreRepositorySaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
