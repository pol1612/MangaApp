package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.models.Manga;

import java.util.List;

public interface MangaRepositoriesDo extends RepositoriesDo<Manga,Integer> {
    public List<Manga> GetAllMangasWhereGenreIs(Genre genre);
}
