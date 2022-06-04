package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPACoverRepository implements RepositoriesDo<Cover, Integer> {
    private final EntityManagerFactory entityManagerFactory;

    public JPACoverRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }

    @Override
    public void save(Cover cover) {
        if(cover.getCoverId()==0){
            insert(cover);
        }else{
            update(cover);
        }
    }
    private void insert(Cover cover){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cover);
        entityManager.getTransaction().commit();
    }
    private void update(Cover cover){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cover);
        entityManager.getTransaction().commit();
    }
    @Override
    public void delete(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var cover=GetById(id);
        if(cover!=null) {
            cover= entityManager.merge(cover);
            entityManager.remove(cover);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Cover GetById(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(Cover.class,id);
    }

    @Override
    public List<Cover> GetAll() {
        var entitYManager=entityManagerFactory.createEntityManager();
        var query=entitYManager.createQuery("SELECT cover FROM Cover cover");
        return query.getResultList();
    }
}
