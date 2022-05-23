package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.cover;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCCoverRepository;
import org.junit.jupiter.api.Test;

class JDBCCoverRepositoryTestSaveUpdate {

    @Test
    void save() {
        Cover berserkCover=new Cover();
        berserkCover.setCoverId(1);
        berserkCover.setCover_path("images3/berserk.jpg");
        berserkCover.setWidth(1520);
        berserkCover.setHeight(2707);
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCCoverRepository coverRepository=new JDBCCoverRepository(dataSourceManager);
        coverRepository.save(berserkCover);
    }
}