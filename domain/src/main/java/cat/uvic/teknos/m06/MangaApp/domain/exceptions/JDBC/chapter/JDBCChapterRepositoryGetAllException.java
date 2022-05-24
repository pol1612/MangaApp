package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter;

public class JDBCChapterRepositoryGetAllException extends RuntimeException{
    public JDBCChapterRepositoryGetAllException() {
    }

    public JDBCChapterRepositoryGetAllException(String message) {
        super(message);
    }

    public JDBCChapterRepositoryGetAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCChapterRepositoryGetAllException(Throwable cause) {
        super(cause);
    }

    public JDBCChapterRepositoryGetAllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
