package cat.uvic.teknos.m06.MangaApp.domain.helpers;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
    Connection getConnection() throws SQLException;
}
