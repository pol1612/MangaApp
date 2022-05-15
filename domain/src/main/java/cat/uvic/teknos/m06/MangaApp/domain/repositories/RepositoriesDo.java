package cat.uvic.teknos.m06.MangaApp.domain.repositories;

public interface RepositoriesDo {
    void save(Object module);
    void delete(Object module);
    void GetById(Object module);
    void GetAll(Object module);
}
