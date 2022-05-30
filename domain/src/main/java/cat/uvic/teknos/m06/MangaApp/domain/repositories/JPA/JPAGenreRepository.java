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
    public void save(Genre genre) {
        if(genre.getGenreId()==0){
            insert(genre);
        }
        else{
            update(genre);
        }
    }
    private void insert(Genre genre){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(genre);
        entityManager.getTransaction().commit();
    }
    private void update(Genre genre){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(genre);
        entityManager.getTransaction().commit();
    }
    @Override
    public void delete(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var genre=GetById(id);
        if(genre!=null) {
           genre= entityManager.merge(genre);
            entityManager.remove(genre);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Genre GetById(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(Genre.class,id);
    }

    @Override
    public List<Genre> GetAll() {
        var entitYManager=entityManagerFactory.createEntityManager();
        var query=entitYManager.createQuery("SELECT genre FROM Genre genre");
        return query.getResultList();
    }
}
