package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import java.util.List;

public interface RepositoriesDo <Tmodel,Key>{
    void save(Tmodel model);
    void delete(Tmodel model);
    //List<Tmodel> GetById(Key id);
    //List<Tmodel> GetAll();
}
