package cat.uvic.teknos.m06.MangaApp.domain.repositories;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MangaRepository implements RepositoriesDo<Manga> {
    private Connection connection;
    MangaRepository(Connection connection, Manga manga){
        this.connection=connection;
    }
    @Override
    public void save(Manga manga) {

    }

    @Override
    public void delete(Integer manga_id) {
    }

    @Override
    public Manga GetById(Integer id){
        return null;
    }

    //@Override
    public List<Manga> GetAll() {
        return null;
    }
}