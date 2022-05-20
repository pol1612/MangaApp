package cat.uvic.teknos.m06.MangaApp.domain.repositories.cover;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.CoverRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoverRepositoryTestGetById {

    @Test
    void getById() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        CoverRepository coverRepository=new CoverRepository(dataSourceManager);
        var cover = coverRepository.GetById(3);
        System.out.println(cover.getCover_path());
    }
}