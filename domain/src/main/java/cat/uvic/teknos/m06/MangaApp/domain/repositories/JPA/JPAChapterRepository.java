package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JPAChapterRepository implements RepositoriesDo<Chapter,Integer>{
    private final EntityManagerFactory entityManagerFactory;

    public JPAChapterRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory=entityManagerFactory;
    }
    @Override
    public void save(Chapter chapter) {
        if(chapter.getChapterId()==0){
            insert(chapter);
        }
        else{
            update(chapter);
        }
    }
    private void insert(Chapter chapter){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(chapter);
        entityManager.getTransaction().commit();
    }
    private void update(Chapter chapter){
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(chapter);
        entityManager.getTransaction().commit();
    }
    @Override
    public void delete(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var chapter=GetById(id);
        if(chapter!=null) {
            chapter= entityManager.merge(chapter);
            entityManager.remove(chapter);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Chapter GetById(Integer id) {
        var entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(Chapter.class,id);
    }

    @Override
    public List<Chapter> GetAll() {
        var entitYManager=entityManagerFactory.createEntityManager();
        var query=entitYManager.createQuery("SELECT chapter FROM Chapter chapter");
        return query.getResultList();
    }
}
