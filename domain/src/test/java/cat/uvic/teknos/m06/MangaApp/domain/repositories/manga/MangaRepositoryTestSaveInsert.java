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
        g1.setGenreId(1);
        Manga manga = new Manga();
        manga.setMangaId(0);
        manga.setTitle("tttttttttttttttttt");
        manga.setDescription("gg");
        manga.setCoverId(2);
        System.out.println(manga.getCoverId());
        System.out.println(manga.getCoverId());
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