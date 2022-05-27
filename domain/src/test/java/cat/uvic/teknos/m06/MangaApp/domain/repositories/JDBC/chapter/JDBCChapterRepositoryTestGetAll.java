package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.chapter;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.models.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCChapterRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class JDBCChapterRepositoryTestGetAll {

    @Test
    void getAll() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCChapterRepository jdbcChapterRepository=new JDBCChapterRepository(dataSourceManager);
        List<Chapter> chapterList=new ArrayList<>();
        /*chapterList=jdbcChapterRepository.GetAll();
        System.out.println(chapterList.get(0).getChapterTitle());*/
    }
}