package cat.uvic.teknos.m06.MangaApp.domain.helpers;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.DataSourceManagerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceManager {
    private ConnectionProperties connectionProperties;
    public DataSourceManager(ConnectionProperties connectionProperties){
       this.connectionProperties=connectionProperties;
    }
   public Connection getConnection() {
       try (var connection = DriverManager.getConnection(
               connectionProperties.getUrl(), connectionProperties.getUser(), connectionProperties.getPassword())) {
            return connection;
       } catch (SQLException e) {
            throw new DataSourceManagerException(e);
       }
   }

}
