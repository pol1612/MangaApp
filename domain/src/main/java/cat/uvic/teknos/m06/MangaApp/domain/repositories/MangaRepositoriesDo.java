package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;

import java.util.List;

public interface MangaRepository extends RepositoriesDo {
    public List<Manga> getAllMangasWhereGenreIs(Genre genre);
}
