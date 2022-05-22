package cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga;

public class MangaRepositoryDeleteException extends RuntimeException{
    public MangaRepositoryDeleteException() {
    }

    public MangaRepositoryDeleteException(String message) {
        super(message);
    }

    public MangaRepositoryDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public MangaRepositoryDeleteException(Throwable cause) {
        super(cause);
    }

    public MangaRepositoryDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
