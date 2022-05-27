package cat.uvic.teknos.m06.MangaApp.domain.repositories.JPA;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class JPAGenreRepositoryTest {

    @Test
    void save() {
        var entityManagerFactory= Persistence.createEntityManagerFactory("MangaApp_mysql");

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