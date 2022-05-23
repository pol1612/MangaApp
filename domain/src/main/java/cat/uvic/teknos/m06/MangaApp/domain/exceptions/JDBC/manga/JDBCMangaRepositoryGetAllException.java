package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.manga;

public class JDBCMangaRepositoryGetAllException extends RuntimeException{
    public JDBCMangaRepositoryGetAllException() {
    }

    public JDBCMangaRepositoryGetAllException(String message) {
        super(message);
    }

    public JDBCMangaRepositoryGetAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCMangaRepositoryGetAllException(Throwable cause) {
        super(cause);
    }

    public JDBCMangaRepositoryGetAllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
