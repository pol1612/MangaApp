package cat.uvic.teknos.m06.MangaApp.domain.repositories.manga;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.MangaRepository;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class MangaRepositoryTestGetById {

    @Test
    void getById() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        MangaRepository mangaRepository=new MangaRepository(dataSourceManager);
        Manga manga=mangaRepository.GetById(9);
        System.out.println(manga.getGenres().get(0).getName());
        System.out.println(manga.getGenres().get(1).getGenreId());


    }
}