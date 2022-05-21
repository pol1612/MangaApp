package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositoryGetByIdException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.genre.GenreRepositoryDeleteException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.genre.GenreRepositoryGetByIdException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.genre.GenreRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import com.mysql.cj.jdbc.ClientPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GenreRepository implements RepositoriesDo<Genre>{
    private final ConnectionManager connectionManager;

    public GenreRepository(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public void save(Genre genre) {
        try (Connection connection=connectionManager.getConnection()){
            PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO MANGA_APP.GENRE (NAME,DESCRIPTION) VALUES(?, ?);");
            PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE MANGA_APP.GENRE SET NAME=?, DESCRIPTION=? WHERE GENRE_ID=?;");
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
        try(Connection connection=connectionManager.getConnection()){
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM MANGA_APP.GENRE WHERE GENRE_ID=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new GenreRepositoryDeleteException(e);
        }
    }

    @Override
    public Genre GetById(Integer id) {
        try(Connection connection=connectionManager.getConnection()){
            Genre genre=new Genre();
            var preparedStatement=connection.prepareStatement("SELECT * FROM MANGA_APP.GENRE WHERE GENRE_ID=?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            var genre_id = resultSet.getInt("GENRE_ID");
            var name = resultSet.getString("NAME");
            var description = resultSet.getString("DESCRIPTION");
            genre.setGenreId(genre_id);
            genre.setName(name);
            genre.setDescription(description);
            return genre;

        }
        catch (SQLException e){
            throw  new GenreRepositoryGetByIdException(e);
        }
    }

    @Override
    public List GetAll() {
        return null;
    }
}
