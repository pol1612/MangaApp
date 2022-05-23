package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.chapter;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCChapterRepository;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class JDBCChapterRepositoryTestSaveUpdate {

    @Test
    void save() {
        Chapter chapter=new Chapter();
        Date date=new Date(23,07,2022);
        chapter.setChapterId(1);
        chapter.setMangaId(2);
        chapter.setChapterNumber(3);
        chapter.setChapterTitle("BERSERK CHAPTER 2: THE EGG");
        chapter.setDateOfUploading(date);
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCChapterRepository jdbcChapterRepository=new JDBCChapterRepository(dataSourceManager);
        jdbcChapterRepository.save(chapter);
    }
}