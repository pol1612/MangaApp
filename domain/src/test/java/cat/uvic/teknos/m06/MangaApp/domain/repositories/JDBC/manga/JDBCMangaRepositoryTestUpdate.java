package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.manga;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.models.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCMangaRepository;
import org.junit.jupiter.api.Test;

class JDBCMangaRepositoryTestUpdate {

    @Test
    void save() {
        Manga m= new Manga();
        m.setMangaId(3);
        m.setTitle("One piece:monkey d luffy");
        m.setDescription("lol and ninjas");
        m.setCoverId(2);
        Genre genre1=new Genre();
        Genre genre=new Genre();
        genre.setGenreId(2);
        genre1.setGenreId(1);
        m.AddGenre(genre1);
        m.AddGenre(genre);
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCMangaRepository mangaRepository=new JDBCMangaRepository(dataSourceManager);
        //mangaRepository.save(m);
    }
}