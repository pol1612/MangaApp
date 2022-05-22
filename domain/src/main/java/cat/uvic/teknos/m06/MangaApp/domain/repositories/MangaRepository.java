package cat.uvic.teknos.m06.MangaApp.domain.repositories;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga.MangaRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Genre;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
                for(int i=0;i<manga.getGenres().size();++i){
                    Genre genre=manga.getGenres().get(i);
                    PreparedStatement preparedStatement3=connection.prepareStatement("INSERT INTO MANGA_APP.MANGA_GENRE_RELATIONSHIP VALUES (?,?);");
                    preparedStatement3.setInt(1,manga.getMangaId());
                    preparedStatement3.setInt(2,genre.getGenreId());
                    System.out.println("**************");
                    System.out.println(manga.getMangaId());
                    System.out.println(genre.getGenreId());
                    System.out.println("**************");
                    preparedStatement3.executeUpdate();
                    System.out.println("lllllllllllllllllll");
                }

            }
            else{
                /*
                preparedStatement2.setString(1,manga.getTitle());
                preparedStatement2.setString(2, manga.getDescription());
                preparedStatement2.setInt(3,manga.getCoverId());
                preparedStatement2.executeUpdate();*/
            }
        }catch (SQLException e){
            throw new MangaRepositorySaveException(e);
        }

    }

    @Override
    public void delete(Integer manga_id) {
    }

    @Override
    public Manga GetById(Integer id){
        return null;
    }

    @Override
    public List<Manga> GetAll() {
        return null;
    }
}