package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.genre;

public class JDBCGenreRepositoryGetByIdException extends RuntimeException{
    public JDBCGenreRepositoryGetByIdException() {
    }

    public JDBCGenreRepositoryGetByIdException(String message) {
        super(message);
    }

    public JDBCGenreRepositoryGetByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCGenreRepositoryGetByIdException(Throwable cause) {
        super(cause);
    }

    public JDBCGenreRepositoryGetByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
