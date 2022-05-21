package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.genre.GenreRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;

import java.sql.SQLException;
import java.util.List;

public class GenreRepository implements RepositoriesDo<Genre>{
    private final ConnectionManager connectionManager;

    public GenreRepository(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public void save(Genre genre) {
        try (var connection=connectionManager.getConnection()){
            var preparedStatement1 = connection.prepareStatement("INSERT INTO MANGA_APP.GENRE (NAME,DESCRIPTION) VALUES(?, ?);");
            var preparedStatement2 = connection.prepareStatement("UPDATE MANGA_APP.GENRE SET NAME=?, DECRIPTION=? WHERE GENRE_ID=?;");
            if (genre.getGenreId() == 0) {
                preparedStatement1.setString(1, genre.getName());
                preparedStatement1.setString(2, genre.getDescription());
                preparedStatement1.executeUpdate();
            }
            else {
                preparedStatement2.setString(1, genre.getName());
                preparedStatement2.setString(2,genre.getDescription());
                preparedStatement2.setInt(3,genre.getGenreId());
                preparedStatement2.executeUpdate();
            }
        }
        catch (SQLException e) {
            throw new GenreRepositorySaveException(e);
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Genre GetById(Integer id) {
        return null;
    }

    @Override
    public List GetAll() {
        return null;
    }
}
