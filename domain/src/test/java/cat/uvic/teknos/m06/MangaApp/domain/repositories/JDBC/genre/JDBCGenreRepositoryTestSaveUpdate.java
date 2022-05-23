package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.genre;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCGenreRepository;
import org.junit.jupiter.api.Test;

class JDBCGenreRepositoryTestSaveUpdate {

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
        JDBCGenreRepository JDBCGenreRepository = new JDBCGenreRepository(dataSourceManager);
        JDBCGenreRepository.save(genre);
    }
}