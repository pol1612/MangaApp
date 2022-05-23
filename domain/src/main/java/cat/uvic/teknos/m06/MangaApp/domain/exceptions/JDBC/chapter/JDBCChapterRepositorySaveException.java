package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter;

public class JDBCChapterRepositorySaveException extends RuntimeException{
    public JDBCChapterRepositorySaveException() {
    }

    public JDBCChapterRepositorySaveException(String message) {
        super(message);
    }

    public JDBCChapterRepositorySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCChapterRepositorySaveException(Throwable cause) {
        super(cause);
    }

    public JDBCChapterRepositorySaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
