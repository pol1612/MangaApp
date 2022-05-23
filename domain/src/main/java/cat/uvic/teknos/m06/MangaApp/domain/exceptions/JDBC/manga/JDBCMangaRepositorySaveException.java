package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.manga;

public class JDBCMangaRepositorySaveException extends RuntimeException{
    public JDBCMangaRepositorySaveException() {
    }

    public JDBCMangaRepositorySaveException(String message) {
        super(message);
    }

    public JDBCMangaRepositorySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCMangaRepositorySaveException(Throwable cause) {
        super(cause);
    }

    public JDBCMangaRepositorySaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
