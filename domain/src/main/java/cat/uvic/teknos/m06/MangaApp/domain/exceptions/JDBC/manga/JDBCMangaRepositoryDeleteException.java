package cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.manga;

public class JDBCMangaRepositoryDeleteException extends RuntimeException{
    public JDBCMangaRepositoryDeleteException() {
    }

    public JDBCMangaRepositoryDeleteException(String message) {
        super(message);
    }

    public JDBCMangaRepositoryDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDBCMangaRepositoryDeleteException(Throwable cause) {
        super(cause);
    }

    public JDBCMangaRepositoryDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
