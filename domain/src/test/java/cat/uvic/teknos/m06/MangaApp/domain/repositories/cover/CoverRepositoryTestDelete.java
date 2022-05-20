package cat.uvic.teknos.m06.MangaApp.domain.repositories.cover;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.CoverRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoverRepositoryTestDelete {

    @Test
    void delete() {
        Cover berserkCover=new Cover();
        berserkCover.setCoverId(1);
        berserkCover.setCover_path("images/berserk.jpg");
        berserkCover.setWidth(150);
        berserkCover.setHeight(270);
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        CoverRepository coverRepository=new CoverRepository(dataSourceManager);
        coverRepository.delete(berserkCover);
    }
}