package cat.uvic.teknos.m06.MangaApp.domain.exceptions;

public class DataSourceManagerException extends RuntimeException{
    public DataSourceManagerException() {
    }

    public DataSourceManagerException(String message) {
        super(message);
    }

    public DataSourceManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataSourceManagerException(Throwable cause) {
        super(cause);
    }

    public DataSourceManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
