package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Manga;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class JPAMangaRepositoryTest {
    public static final int MODEL_TO_DELETE=2;
    private static EntityManagerFactory entityManagerFactory;
    private static JPAMangaRepository jpaMangaRepository;

    @BeforeAll
    static void setUp(){
        entityManagerFactory= Persistence.createEntityManagerFactory("MangaApp_mysql");
        jpaMangaRepository=new JPAMangaRepository(entityManagerFactory);
    }
    @Test
    void saveInsert() {
        var manga=new Manga();
        manga.setMangaId(0);
        manga.setTitle("Boku no hero academia");
        manga.setDescription("heroes and shit");
        manga.setCoverId(5);
        assertDoesNotThrow(()-> {
            jpaMangaRepository.save(manga);
        });
        assertTrue(manga.getCoverId()>0);
    }

    @Test
    void saveUpdate() {

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