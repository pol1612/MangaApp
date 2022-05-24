package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.manga;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCMangaRepository;
import org.junit.jupiter.api.Test;

class JDBCMangaRepositoryTestGetById {

    @Test
    void getById() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCMangaRepository JDBCMangaRepository =new JDBCMangaRepository(dataSourceManager);
        Manga manga= JDBCMangaRepository.GetById(9);
        System.out.println(manga.getGenres().get(0).getName());
        System.out.println(manga.getGenres().get(1).getGenreId());
    }
}