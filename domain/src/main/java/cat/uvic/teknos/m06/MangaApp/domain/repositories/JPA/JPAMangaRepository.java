package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.models.Manga;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPAMangaRepository implements RepositoriesDo<Manga,Integer> {

    private final EntityManagerFactory entityManagerFactory;

    public JPAMangaRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }
    @Override
    public void save(Manga manga) {
        if(manga.getMangaId()==0){
            insert(manga);
        }else{
            update(manga);
        }
    }
    private void insert(Manga manga){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(manga);
        entityManager.getTransaction().commit();
    }
    private void update(Manga manga){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(manga);
        entityManager.getTransaction().commit();
    }
    @Override
    public void delete(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var manga=GetById(id);
        if(manga!=null) {
            manga= entityManager.merge(manga);
            entityManager.remove(manga);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Manga GetById(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(Manga.class,id);
    }

    @Override
    public List<Manga> GetAll() {
        var entitYManager=entityManagerFactory.createEntityManager();
        var query=entitYManager.createQuery("SELECT manga FROM Manga manga");
        return query.getResultList();
    }
}
