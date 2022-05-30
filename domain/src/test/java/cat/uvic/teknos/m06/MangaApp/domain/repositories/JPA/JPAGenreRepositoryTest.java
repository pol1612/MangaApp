package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class JPAGenreRepositoryTest {
    public static final int MODEL_TO_DELETE=2;
    private static EntityManagerFactory entityManagerFactory;
    private static JPAGenreRepository jpaGenreRepository;
    @BeforeAll
    static void setUp(){
        entityManagerFactory=Persistence.createEntityManagerFactory("MangaApp_mysql");
        jpaGenreRepository=new JPAGenreRepository(entityManagerFactory);

    }
    @Test
    void saveInsert() {
        var genre=new Genre();
        genre.setName("Martial2 arts");
        genre.setDescription("uuuuuuuuuuuuuuuuuuuuuuuuuuu");
        assertDoesNotThrow(()-> {
            jpaGenreRepository.save(genre);
        });
        assertTrue(genre.getGenreId()>0);

    }
    @Test
    void saveUpdate(){
        var genre=new Genre();
        genre.setName("water");
        genre.setDescription("poopoo");
        genre.setGenreId(1);
        assertDoesNotThrow(()-> {
            jpaGenreRepository.save(genre);
        });

    }
    @Test
    void delete() {
        var entityManager=entityManagerFactory.createEntityManager();
        var entityManager1=entityManagerFactory.createEntityManager();
        var rom=entityManager.find(Genre.class, MODEL_TO_DELETE);

        assertNotNull(rom);

        assertDoesNotThrow(() -> {
            jpaGenreRepository.delete(MODEL_TO_DELETE);
        });

        rom=entityManager1.find(Genre.class,MODEL_TO_DELETE);

        assertNull(rom);
    }

    @Test
    void getById() {
        var genre=jpaGenreRepository.GetById(2);


    }

    @Test
    void getAll() {
    }
}