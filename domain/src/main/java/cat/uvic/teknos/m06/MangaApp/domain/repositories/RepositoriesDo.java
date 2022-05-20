package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import java.util.List;

public interface RepositoriesDo <Tmodel>{
    void save(Tmodel model);
    void delete(Integer id);
    Tmodel GetById(Integer id);
    //List<Tmodel> GetAll();
}
