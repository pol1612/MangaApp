package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.cover;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCCoverRepository;
import org.junit.jupiter.api.Test;

class JDBCCoverRepositoryTestDelete {

    @Test
    void delete() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCCoverRepository coverRepository=new JDBCCoverRepository(dataSourceManager);
        coverRepository.delete(3);
    }
}