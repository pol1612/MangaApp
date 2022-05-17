package cat.uvic.teknos.m06.MangaApp.domain.helpers;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceManager {
    private ConnectionProperties connectionProperties;
    DataSourceManager(ConnectionProperties connectionProperties){
       this.connectionProperties=connectionProperties;
   }
   public void main(String[] args) {
       try (var connection = DriverManager.getConnection(
               connectionProperties.getUrl(), connectionProperties.getUser(), connectionProperties.getPassword())) {

       } catch (SQLException e) {

       }
   }
}
