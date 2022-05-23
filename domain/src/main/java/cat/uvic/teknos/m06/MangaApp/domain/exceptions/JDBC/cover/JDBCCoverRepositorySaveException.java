package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.cover;

public class JDBCCoverRepositorySaveException extends RuntimeException{
    public JDBCCoverRepositorySaveException() {
    }

    public JDBCCoverRepositorySaveException(String message) {
        super(message);
    }

    public JDBCCoverRepositorySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCCoverRepositorySaveException(Throwable cause) {
        super(cause);
    }

    public JDBCCoverRepositorySaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
