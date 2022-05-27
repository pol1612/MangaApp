package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.models.Genre;

import java.util.List;

public interface RepositoriesDo <Tmodel,Key>{
    void save(Tmodel model);
    void delete(Key id);
    Tmodel GetById(Key id);
    List<Tmodel> GetAll();
}
