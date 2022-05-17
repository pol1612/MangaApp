package cat.uvic.teknos.m06.MangaApp.domain.helpers;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}
