package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.cover;

public class JDBCCoverRepositoryDeleteException extends RuntimeException{
    public JDBCCoverRepositoryDeleteException() {
    }

    public JDBCCoverRepositoryDeleteException(String message) {
        super(message);
    }

    public JDBCCoverRepositoryDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCCoverRepositoryDeleteException(Throwable cause) {
        super(cause);
    }

    public JDBCCoverRepositoryDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
