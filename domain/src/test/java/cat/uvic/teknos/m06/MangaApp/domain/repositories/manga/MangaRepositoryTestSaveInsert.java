package cat.uvic.teknos.m06.MangaApp.domain.repositories.manga;

import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;
import org.junit.jupiter.api.Test;

class MangaRepositoryTestSaveInsert {

    @Test
    void save() {
        Manga manga = new Manga();
        manga.setMangaId(0);
        manga.setTitle("One piece");
        //el insert d'un manga tmb ha de fer el insert dels genres del manga
        //el save s'ha de modificar
    }
}