package cat.uvic.teknos.m06.MangaApp.domain.repositories;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga.MangaRepositoryDeleteException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga.MangaRepositoryGetByIdException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga.MangaRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;


import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class MangaRepository implements RepositoriesDo<Manga> {
    private final ConnectionManager connectionManager;

    public MangaRepository(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public void save(Manga manga) {
        try(Connection connection= connectionManager.getConnection()){
            PreparedStatement preparedStatement1=connection.prepareStatement("INSERT INTO MANGA_APP.MANGA (TITLE,DESCRIPTION,COVER_ID) VALUES (?,?,?);", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement preparedStatement2=connection.prepareStatement("UPDATE MANGA_APP.MANGA SET TITLE=?,DESCRIPTION=?,COVER_ID=? WHERE MANGA_ID=?;", Statement.RETURN_GENERATED_KEYS);

            if(manga.getMangaId()==0) {
                preparedStatement1.setString(1, manga.getTitle());
                preparedStatement1.setString(2, manga.getDescription());
                preparedStatement1.setInt(3, manga.getCoverId());
                preparedStatement1.executeUpdate();
                ResultSet resultSet = preparedStatement1.getGeneratedKeys();
                resultSet.next();
                for(int i=0;i<manga.getGenres().size();++i){
                    Genre genre=manga.getGenres().get(i);
                    PreparedStatement preparedStatement3=connection.prepareStatement("INSERT INTO MANGA_APP.MANGA_GENRE_RELATIONSHIP VALUES (?,?);");
                    preparedStatement3.setInt(1,resultSet.getInt(1));
                    preparedStatement3.setInt(2,genre.getGenreId());
                    preparedStatement3.executeUpdate();
                }

            }
            else{
                PreparedStatement preparedStatement3= connection.prepareStatement("UPDATE MANGA_APP.MANGA SET TITLE=?,DESCRIPTION=?,COVER_ID=? WHERE MANGA_ID=?;");
                PreparedStatement preparedStatement4=connection.prepareStatement("DELETE FROM MANGA_APP.MANGA_GENRE_RELATIONSHIP WHERE MANGA_ID=?;");
                preparedStatement3.setString(1,manga.getTitle());
                preparedStatement3.setString(2,manga.getDescription());
                preparedStatement3.setInt(3,manga.getCoverId());
                preparedStatement3.setInt(4,manga.getMangaId());
                preparedStatement3.executeUpdate();
                preparedStatement4.setInt(1,manga.getMangaId());
                preparedStatement4.executeUpdate();
                for(int i=0;i<manga.getGenres().size();++i){
                    Genre genre=manga.getGenres().get(i);
                    PreparedStatement preparedStatement5=connection.prepareStatement("INSERT INTO MANGA_APP.MANGA_GENRE_RELATIONSHIP VALUES (?,?);");
                    preparedStatement5.setInt(1,manga.getMangaId());
                    preparedStatement5.setInt(2,genre.getGenreId());
                    preparedStatement5.executeUpdate();
                }
            }
        }catch (SQLException e){
            throw new MangaRepositorySaveException(e);
        }

    }

    @Override
    public void delete(Integer manga_id) {
        try(Connection connection=connectionManager.getConnection()){
            PreparedStatement preparedStatement1=connection.prepareStatement("DELETE FROM MANGA_APP.CHAPTER WHERE MANGA_ID=?;");
            PreparedStatement preparedStatement2=connection.prepareStatement("DELETE FROM MANGA_APP.MANGA_GENRE_RELATIONSHIP WHERE MANGA_ID=?;");
            PreparedStatement preparedStatement3=connection.prepareStatement("DELETE FROM MANGA_APP.MANGA WHERE MANGA_ID=?;");
            preparedStatement1.setInt(1,manga_id);
            preparedStatement2.setInt(1,manga_id);
            preparedStatement3.setInt(1,manga_id);
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement3.executeUpdate();
        }catch (SQLException e){
            throw new MangaRepositoryDeleteException(e);
        }
    }

    @Override
    public Manga GetById(Integer id){
        try(Connection connection = connectionManager.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MANGA_APP.MANGA WHERE MANGA_ID=?;");
            PreparedStatement preparedStatement1=connection.prepareStatement("SELECT * FROM MANGA_APP.MANGA_GENRE_RELATIONSHIP WHERE MANGA_ID=?;");
            Manga manga= new Manga();
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            manga.setMangaId(resultSet.getInt("MANGA_ID"));
            manga.setTitle(resultSet.getString("TITLE"));
            manga.setDescription(resultSet.getString("DESCRIPTION"));
            manga.setCoverId(resultSet.getInt("COVER_ID"));
            preparedStatement1.setInt(1,manga.getMangaId());
            ResultSet resultSet1=preparedStatement1.executeQuery();
            while(resultSet1.next()){
                PreparedStatement preparedStatement2=connection.prepareStatement("SELECT * FROM MANGA_APP.GENRE WHERE GENRE_ID=?;");
                Genre genre =new Genre();
                genre.setGenreId(resultSet1.getInt("GENRE_ID"));
                preparedStatement2.setInt(1,genre.getGenreId());
                ResultSet resultSet2=preparedStatement2.executeQuery();
                resultSet2.next();
                genre.setName(resultSet2.getString("NAME"));
                genre.setDescription(resultSet2.getString("DESCRIPTION"));
                manga.AddGenre(genre);
            }
            return manga;

        }catch (SQLException e){
            throw  new MangaRepositoryGetByIdException(e);
        }
    }

    @Override
    public List<Manga> GetAll() {
        try(Connection connection=connectionManager.getConnection()){

        }catch (SQLException e) {
            throw new
        }
    }
}