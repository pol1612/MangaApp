package cat.uvic.teknos.m06.MangaApp.domain.repositories;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;


import java.sql.Connection;
import java.sql.SQLException;

public class MangaRepository implements RepositoriesDo {
    private Connection connection;
    private Manga manga;
    MangaRepository(Connection connection, Manga manga){
        this.connection=connection;
        this.manga=manga;
    }
    @Override
    public void save() {

    }

    @Override
    public void delete() {
    }

    @Override
    public void GetById(int id) {

    }

    @Override
    public void GetAll() {

    }
}