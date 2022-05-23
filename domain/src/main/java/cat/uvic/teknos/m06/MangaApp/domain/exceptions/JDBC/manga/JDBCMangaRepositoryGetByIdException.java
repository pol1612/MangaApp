package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.manga;

public class JDBCMangaRepositoryGetByIdException extends RuntimeException{
    public JDBCMangaRepositoryGetByIdException() {
    }

    public JDBCMangaRepositoryGetByIdException(String message) {
        super(message);
    }

    public JDBCMangaRepositoryGetByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCMangaRepositoryGetByIdException(Throwable cause) {
        super(cause);
    }

    public JDBCMangaRepositoryGetByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
