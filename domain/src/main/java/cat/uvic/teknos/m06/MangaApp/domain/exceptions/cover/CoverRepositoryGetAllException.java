package cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover;

import java.sql.SQLException;

public class CoverRepositoryGetAllException extends RuntimeException {
    public CoverRepositoryGetAllException() {
    }

    public CoverRepositoryGetAllException(String message) {
        super(message);
    }

    public CoverRepositoryGetAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoverRepositoryGetAllException(Throwable cause) {
        super(cause);
    }

    public CoverRepositoryGetAllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
