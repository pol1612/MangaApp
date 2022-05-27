package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.cover;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.models.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCCoverRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class JDBCCoverRepositoryTestGetAll {

    @Test
    void GetAll() {
        List<Cover> list= new ArrayList<>();
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCCoverRepository coverRepository=new JDBCCoverRepository(dataSourceManager);
        /*list=coverRepository.GetAll();
        System.out.println(list.get(0).getCover_path());
        System.out.println(list.get(1).getCoverId());
        System.out.println(list.get(2).getCover_path());
        */
    }
}