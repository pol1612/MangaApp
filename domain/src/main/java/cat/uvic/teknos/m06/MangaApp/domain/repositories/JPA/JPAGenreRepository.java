package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;
import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPAGenreRepository implements RepositoriesDo<Genre, Integer> {
    private final EntityManagerFactory entityManagerFactory;
    public JPAGenreRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }
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
