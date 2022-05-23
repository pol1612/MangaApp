package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.genre;

public class JDBCGenreRepositorySaveException extends RuntimeException{
    public JDBCGenreRepositorySaveException() {
    }

    public JDBCGenreRepositorySaveException(String message) {
        super(message);
    }

    public JDBCGenreRepositorySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCGenreRepositorySaveException(Throwable cause) {
        super(cause);
    }

    public JDBCGenreRepositorySaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
