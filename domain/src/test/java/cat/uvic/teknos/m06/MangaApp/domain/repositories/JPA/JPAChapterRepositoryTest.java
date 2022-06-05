package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class JPAChapterRepositoryTest {
    public static final int MODEL_TO_DELETE=2;
    private static EntityManagerFactory entityManagerFactory;
    private static JPAChapterRepository jpaChapterRepository;
    @BeforeAll
    static void setUp(){
        entityManagerFactory= Persistence.createEntityManagerFactory("MangaApp_mysql");
        jpaChapterRepository=new JPAChapterRepository(entityManagerFactory);

    }
    @Test
    void saveInsert() {
        var chapter=new Chapter();
        chapter.setChapterNumber(1);
        chapter.setChapterTitle("age of stone");
        Date date=new Date(2022-06-05);
        chapter.setDateOfUploading(date);
        chapter.setMangaId(3);
        assertDoesNotThrow(()-> {
            jpaChapterRepository.save(chapter);
        });
        assertTrue(chapter.getChapterId()>0);
    }
    @Test
    void saveUpdate(){
       var chapter=new Chapter();
       chapter.setChapterId(1);
       chapter.setChapterTitle("A long time ago");
       chapter.setChapterNumber(0);
       chapter.setMangaId(1);
        Date date=new Date(2021-04-17);
       chapter.setDateOfUploading(date);
        assertDoesNotThrow(()-> {
            jpaChapterRepository.save(chapter);
        });
        var entityManager=entityManagerFactory.createEntityManager();
        var modifiedChapter=entityManager.find(Chapter.class,1);
        assertEquals("A long time ago", modifiedChapter.getChapterTitle());
        entityManager.close();
    }
    @Test
    void delete() {
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
    }
}