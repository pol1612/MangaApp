package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter;

public class JDBCChapterRepositoryGetByIdException extends RuntimeException{
    public JDBCChapterRepositoryGetByIdException() {
    }

    public JDBCChapterRepositoryGetByIdException(String message) {
        super(message);
    }

    public JDBCChapterRepositoryGetByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCChapterRepositoryGetByIdException(Throwable cause) {
        super(cause);
    }

    public JDBCChapterRepositoryGetByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
