package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.genre;

public class JDBCGenreRepositoryGetAllException extends RuntimeException{
    public JDBCGenreRepositoryGetAllException() {
    }

    public JDBCGenreRepositoryGetAllException(String message) {
        super(message);
    }

    public JDBCGenreRepositoryGetAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCGenreRepositoryGetAllException(Throwable cause) {
        super(cause);
    }

    public JDBCGenreRepositoryGetAllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
