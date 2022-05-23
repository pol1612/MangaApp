package cat.uvic.teknos.m06.MangaApp.domain.repositories.manga;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.DataSourceManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.MangaRepository;
import org.junit.jupiter.api.Test;

class MangaRepositoryTestSaveInsert {

    @Test
    void save() {
        Genre g1= new Genre();
        Genre g2=new Genre();
        g2.setGenreId(2);
        g1.setGenreId(1);
        Manga manga = new Manga();
        manga.setMangaId(0);
        manga.setTitle("berserk2");
        manga.setDescription("the destiny2 of a man who is dead");
        manga.setCoverId(2);
        manga.AddGenre(g1);
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        connectionProperties.setPassword(null);
        DataSourceManager dataSourceManager=new DataSourceManager(connectionProperties);
        MangaRepository mangaRepository=new MangaRepository(dataSourceManager);
        mangaRepository.save(manga);
        //el insert d'un manga tmb ha de fer el insert dels genres del manga
        //el save s'ha de modificar
    }
}