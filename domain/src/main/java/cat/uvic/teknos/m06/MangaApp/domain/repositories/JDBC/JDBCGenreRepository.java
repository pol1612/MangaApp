package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.genre.JDBCGenreRepositoryDeleteException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.genre.JDBCGenreRepositoryGetAllException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.genre.JDBCGenreRepositoryGetByIdException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.genre.JDBCGenreRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCGenreRepository implements RepositoriesDo<Genre> {
    private final ConnectionManager connectionManager;

    public JDBCGenreRepository(ConnectionManager connectionManager) {
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
            throw new JDBCGenreRepositorySaveException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection connection=connectionManager.getConnection()){
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM MANGA_APP.GENRE WHERE GENRE_ID=?");
            PreparedStatement preparedStatement1=connection.prepareStatement("DELETE FROM MANGA_APP.MANGA_GENRE_RELATIONSHIP WHERE GENRE_ID=?;");
            preparedStatement.setInt(1,id);
            preparedStatement1.setInt(1,id);
            preparedStatement1.executeUpdate();
            preparedStatement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            throw new JDBCGenreRepositoryDeleteException(e);
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
            throw  new JDBCGenreRepositoryGetByIdException(e);
        }
    }

    @Override
    public List<Genre> GetAll() {
        try(Connection connection= connectionManager.getConnection()){
            List<Genre> list= new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql="SELECT * FROM MANGA_APP.GENRE;";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Genre genre= new Genre();
                genre.setGenreId(resultSet.getInt("GENRE_ID"));
                genre.setName(resultSet.getString("NAME"));
                genre.setDescription(resultSet.getString("DESCRIPTION"));
                list.add(genre);
            }
            return list;
        }catch (SQLException e){
            throw new JDBCGenreRepositoryGetAllException(e);
        }
    }
}
