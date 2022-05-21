package cat.uvic.teknos.m06.MangaApp.domain.exceptions.genre;

public class GenreRepositoryDeleteException extends RuntimeException{
    public GenreRepositoryDeleteException() {
    }

    public GenreRepositoryDeleteException(String message) {
        super(message);
    }

    public GenreRepositoryDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenreRepositoryDeleteException(Throwable cause) {
        super(cause);
    }

    public GenreRepositoryDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
