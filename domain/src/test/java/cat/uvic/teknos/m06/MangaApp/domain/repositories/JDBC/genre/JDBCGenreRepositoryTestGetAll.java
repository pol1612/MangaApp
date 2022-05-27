package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.genre;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCGenreRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

class JDBCGenreRepositoryTestGetAll {

    @Test
    void getAll() {
        List<Genre> list;
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCGenreRepository genreRepository=new JDBCGenreRepository(dataSourceManager);
        /*list=genreRepository.GetAll();
        System.out.println(list.get(0).getDescription());
        System.out.println(list.get(1).getName());
        System.out.println(list.get(2).getGenreId());
        */
    }
}