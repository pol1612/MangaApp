package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class JPAGenreRepositoryTest {
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