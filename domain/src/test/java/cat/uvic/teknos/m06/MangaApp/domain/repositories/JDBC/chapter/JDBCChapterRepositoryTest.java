package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.chapter;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCChapterRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JDBCChapterRepositoryTest {

    @Test
    void delete() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCChapterRepository jdbcChapterRepository=new JDBCChapterRepository(dataSourceManager);
        //jdbcChapterRepository.delete(2);
    }
}