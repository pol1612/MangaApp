package cat.uvic.teknos.m06.MangaApp.domain.repositories;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MangaRepository implements RepositoriesDo<Manga, Integer> {
    private Connection connection;
    MangaRepository(Connection connection, Manga manga){
        this.connection=connection;
    }
    @Override
    public void save(Manga manga) {

    }

    @Override
    public void delete(Manga manga) {
    }

    //@Override
    public List<Manga> GetById(int id){

    }

    //@Override
    public List<Manga> GetAll() {

    }
}