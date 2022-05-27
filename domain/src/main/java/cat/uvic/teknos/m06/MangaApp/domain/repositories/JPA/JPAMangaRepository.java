package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.models.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.MangaRepositoriesDo;

import java.util.List;

public class JPAMangaRepository implements MangaRepositoriesDo{

    @Override
    public void save(Manga model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Manga GetById(Integer id) {
        return null;
    }

    @Override
    public List<Manga> GetAll() {
        return null;
    }

    @Override
    public List<Manga> GetAllMangasWhereGenreIs(Genre genre){
        return null;
    }
}
