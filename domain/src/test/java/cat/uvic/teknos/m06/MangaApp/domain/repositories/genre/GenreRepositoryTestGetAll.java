package cat.uvic.teknos.m06.MangaApp.domain.repositories.genre;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.CoverRepository;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.GenreRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreRepositoryTestGetAll {

    @Test
    void getAll() {
        List<Genre> list;
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        GenreRepository genreRepository=new GenreRepository(dataSourceManager);
        list=genreRepository.GetAll();
        System.out.println(list.get(0).getDescription());
        System.out.println(list.get(1).getName());
        System.out.println(list.get(2).getGenreId());
    }
}