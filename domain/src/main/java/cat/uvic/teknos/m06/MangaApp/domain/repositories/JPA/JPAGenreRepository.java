package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;
import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import java.util.List;

public class JPAGenreRepository implements RepositoriesDo<Genre, Integer> {
    @Override
    public void save(Genre model) {
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Genre GetById(Integer id) {
        return null;
    }

    @Override
    public List GetAll() {
        return null;
    }
}
