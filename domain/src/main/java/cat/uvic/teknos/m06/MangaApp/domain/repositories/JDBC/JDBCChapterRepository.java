package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC;

import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter.JDBCChapterRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCChapterRepository implements RepositoriesDo<Chapter> {
    private final ConnectionManager connectionManager;

    public JDBCChapterRepository(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public void save(Chapter chapter) {
    try(Connection connection= connectionManager.getConnection()){

    }catch (SQLException e){
        throw new JDBCChapterRepositorySaveException(e);
    }
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
