package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.cover;

public class JDBCCoverRepositoryGetAllException extends RuntimeException {
    public JDBCCoverRepositoryGetAllException() {
    }

    public JDBCCoverRepositoryGetAllException(String message) {
        super(message);
    }

    public JDBCCoverRepositoryGetAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCCoverRepositoryGetAllException(Throwable cause) {
        super(cause);
    }

    public JDBCCoverRepositoryGetAllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
