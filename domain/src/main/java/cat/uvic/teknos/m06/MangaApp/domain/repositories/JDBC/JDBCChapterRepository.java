package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC;

import cat.uvic.teknos.m06.MangaApp.domain.modules.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import java.util.List;

public class JDBCChapterRepository implements RepositoriesDo<Chapter> {

    @Override
    public void save(Chapter chapter) {
        
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Chapter GetById(Integer id) {
        return null;
    }

    @Override
    public List<Chapter> GetAll() {
        return null;
    }
}
