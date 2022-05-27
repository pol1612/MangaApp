package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.genre;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCGenreRepository;
import org.junit.jupiter.api.Test;

class JDBCGenreRepositoryTestGetById {

    @Test
    void getById() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCGenreRepository genreRepository=new JDBCGenreRepository(dataSourceManager);
        /*var cover = genreRepository.GetById(3);
        System.out.println(cover.getDescription());*/
    }
}