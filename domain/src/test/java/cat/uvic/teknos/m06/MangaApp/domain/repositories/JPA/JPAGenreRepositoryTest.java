package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class JPAGenreRepositoryTest {

    @Test
    void save() {
        var entityManagerFactory= Persistence.createEntityManagerFactory("MangaApp_mysql");
        var jpaGenreRepository=new JPAGenreRepository(entityManagerFactory);
        var genre=new Genre();
        genre.setName("Martial2 arts");
        genre.setDescription("uuuuuuuuuuuuuuuuuuuuuuuuuuu");
        assertDoesNotThrow(()-> {
            jpaGenreRepository.save(genre);
        });
        assertTrue(genre.getGenreId()>0);
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