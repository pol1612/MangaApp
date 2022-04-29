package cat.uvic.teknos.m06.MangaApp.utilities.exceptions;

public class SchemaLoaderException extends RuntimeException{
    public SchemaLoaderException() {
    }

    public SchemaLoaderException(String message) {
        super(message);
    }

    public SchemaLoaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public SchemaLoaderException(Throwable cause) {
        super(cause);
    }

    public SchemaLoaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}


