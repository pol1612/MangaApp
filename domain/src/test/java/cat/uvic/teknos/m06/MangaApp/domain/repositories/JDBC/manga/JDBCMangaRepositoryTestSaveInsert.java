package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.manga;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC.JDBCMangaRepository;
import org.junit.jupiter.api.Test;

class JDBCMangaRepositoryTestSaveInsert {

    @Test
    void save() {
        Genre g1= new Genre();
        Genre g2=new Genre();
        g2.setGenreId(3);
        g1.setGenreId(1);
        Manga manga = new Manga();
        manga.setMangaId(0);
        manga.setTitle("GANTZS");
        manga.setDescription("ASFADAD");
        manga.setCoverId(1);
        manga.AddGenre(g1);
        manga.AddGenre(g2);
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        JDBCMangaRepository mangaRepository=new JDBCMangaRepository(dataSourceManager);
        //mangaRepository.save(manga);
        //el insert d'un manga tmb ha de fer el insert dels genres del manga
        //el sav
        // e s'ha de modificar
    }
}