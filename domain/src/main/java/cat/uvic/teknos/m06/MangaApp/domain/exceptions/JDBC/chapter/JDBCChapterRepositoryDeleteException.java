package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter;

public class JDBCChapterRepositoryDeleteException extends RuntimeException{
    public JDBCChapterRepositoryDeleteException() {
    }

    public JDBCChapterRepositoryDeleteException(String message) {
        super(message);
    }

    public JDBCChapterRepositoryDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCChapterRepositoryDeleteException(Throwable cause) {
        super(cause);
    }

    public JDBCChapterRepositoryDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
