package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import java.util.List;

public class JPAMangaRepository implements RepositoriesDo<Manga,Integer> {

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
}
