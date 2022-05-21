package cat.uvic.teknos.m06.MangaApp.domain.repositories.cover;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.CoverRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CoverRepositoryTestGetAll {

    @Test
    void GetAll() {
        List<Cover> list= new ArrayList<>();
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        CoverRepository coverRepository=new CoverRepository(dataSourceManager);
        list=coverRepository.GetAll();
        System.out.println(list.get(0).getCover_path());
        System.out.println(list.get(1).getCoverId());
        System.out.println(list.get(2).getCover_path());

    }
}