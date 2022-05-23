package cat.uvic.teknos.m06.MangaApp.domain.repositories.manga;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.MangaRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MangaRepositoryTestGetAll {

    @Test
    void getAll() {
        List<Manga> mangaList;
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        MangaRepository mangaRepository=new MangaRepository(dataSourceManager);
        mangaList=mangaRepository.GetAll();
        System.out.println(mangaList.get(0).getTitle());
        System.out.println(mangaList.get(0).getGenres().get(1).getName());
        System.out.println(mangaList.get(1).getTitle());
        System.out.println(mangaList.get(1).getGenres().get(0).getName());

    }
}