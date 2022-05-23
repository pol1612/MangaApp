package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;

import java.util.List;

public interface MangaRepositoriesDo extends RepositoriesDo<Manga> {
    public List<Manga> GetAllMangasWhereGenreIs(Genre genre);
}
