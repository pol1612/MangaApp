package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.cover;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCCoverRepository;
import org.junit.jupiter.api.Test;

class JDBCCoverRepositoryTestGetById {

    @Test
    void getById() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCCoverRepository JDBCCoverRepository =new JDBCCoverRepository(dataSourceManager);
        /*var cover = JDBCCoverRepository.GetById(3);
        System.out.println(cover.getCover_path());
        */
    }
}