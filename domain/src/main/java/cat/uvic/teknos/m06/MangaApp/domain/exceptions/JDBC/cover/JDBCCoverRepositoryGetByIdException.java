package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.cover;

public class JDBCCoverRepositoryGetByIdException extends RuntimeException{
    public JDBCCoverRepositoryGetByIdException() {
    }

    public JDBCCoverRepositoryGetByIdException(String message) {
        super(message);
    }

    public JDBCCoverRepositoryGetByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCCoverRepositoryGetByIdException(Throwable cause) {
        super(cause);
    }

    public JDBCCoverRepositoryGetByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
