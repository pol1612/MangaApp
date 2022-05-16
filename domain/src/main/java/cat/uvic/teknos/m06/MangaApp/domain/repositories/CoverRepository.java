package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;

import java.sql.Connection;

public class CoverRepository implements RepositoriesDo{
    private Connection connection;
    private Cover cover;
    CoverRepository(Connection connection, Cover cover){
        this.connection=connection;
        this.cover=cover;
    }
    @Override
    public void save() {
    
    }

    @Override
    public void delete() {

    }

    @Override
    public void GetById() {

    }

    @Override
    public void GetAll() {

    }
}
