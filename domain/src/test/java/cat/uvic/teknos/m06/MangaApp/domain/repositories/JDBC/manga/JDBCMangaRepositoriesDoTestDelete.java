package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.manga;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCMangaRepository;
import org.junit.jupiter.api.Test;

class JDBCMangaRepositoriesDoTestDelete {

    @Test
    void delete() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCMangaRepository mangaRepository=new JDBCMangaRepository(dataSourceManager);
       // mangaRepository.delete(7);
    }
}