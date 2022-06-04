package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class JPACoverRepositoryTest {

    public static final int MODEL_TO_DELETE=1;
    private static EntityManagerFactory entityManagerFactory;
    private static JPACoverRepository jpaCoverRepository;
    @BeforeAll
    static void setUp(){
        entityManagerFactory= Persistence.createEntityManagerFactory("MangaApp_mysql");
        jpaCoverRepository =new JPACoverRepository(entityManagerFactory);

    }

    @Test
    void saveInsert() {
        var cover=new Cover();
        cover.setCoverId(0);
        cover.setCover_path("images/bokuNoHeroCover.png");
        cover.setWidth(160);
        cover.setHeight(10);
        assertDoesNotThrow(()-> {
            jpaCoverRepository.save(cover);
        });
        assertTrue(cover.getCoverId()>0);
    }
    @Test
    void saveUpdate(){
        var cover=new Cover();
        cover.setCoverId(2);
        cover.setCover_path("images/onePieceVolume1Cover.png");
        cover.setHeight(50);
        cover.setWidth(50);
        assertDoesNotThrow(()-> {
            jpaCoverRepository.save(cover);
        });
        var entityManager=entityManagerFactory.createEntityManager();
        var modifiedGenre=entityManager.find(Cover.class,2);
        assertEquals("images/onePieceVolume1Cover.png", modifiedGenre.getCover_path());
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