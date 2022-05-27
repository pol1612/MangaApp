package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.chapter;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCChapterRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JDBCChapterRepositoryTestGetById {

    @Test
    void getById() {
        Chapter chapter;
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCChapterRepository jdbcChapterRepository=new JDBCChapterRepository(dataSourceManager);
        /*chapter=jdbcChapterRepository.GetById(2);
        System.out.println(chapter.getChapterId());
        System.out.println(chapter.getChapterNumber());
        System.out.println(chapter.getChapterTitle());
        System.out.println(chapter.getMangaId());
        System.out.println(chapter.getDateOfUploading());
        */

    }
}