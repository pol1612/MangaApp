package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.chapter;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCChapterRepository;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class JDBCChapterRepositoryTestSaveInsert {

    @Test
    void save() {
        Chapter chapter=new Chapter();
        Date date=new Date(23,05,2022);
        chapter.setChapterId(0);
        chapter.setMangaId(1);
        chapter.setChapterNumber(1);
        chapter.setChapterTitle("BERSERK CHAPTER 1: THE EGG");
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