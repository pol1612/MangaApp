package cat.uvic.teknos.m06.MangaApp.domain.repositories.genre;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.GenreRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreRepositoryTestSaveUpdate {

    @Test
    void save() {
        Genre genre = new Genre();
        genre.setGenreId(3);
        genre.setName("lol");
        genre.setDescription("isekai quartet");
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        GenreRepository genreRepository = new GenreRepository(dataSourceManager);
        genreRepository.save(genre);
    }
}