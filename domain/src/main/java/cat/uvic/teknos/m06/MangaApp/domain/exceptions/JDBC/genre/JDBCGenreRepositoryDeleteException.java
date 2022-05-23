package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.genre;

public class JDBCGenreRepositoryDeleteException extends RuntimeException{
    public JDBCGenreRepositoryDeleteException() {
    }

    public JDBCGenreRepositoryDeleteException(String message) {
        super(message);
    }

    public JDBCGenreRepositoryDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCGenreRepositoryDeleteException(Throwable cause) {
        super(cause);
    }

    public JDBCGenreRepositoryDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
