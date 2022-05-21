package cat.uvic.teknos.m06.MangaApp.domain.repositories;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.manga.MangaRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Manga;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MangaRepository implements RepositoriesDo<Manga> {
    private final ConnectionManager connectionManager;

    public MangaRepository(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public void save(Manga manga) {
        try(Connection connection= connectionManager.getConnection()){
            PreparedStatement preparedStatement1=connection.prepareStatement("INSERT INTO MANGA_APP.MANAGA (TITLE,DESCRIPTION,COVER_ID) VALUES (?,?,?);");
            PreparedStatement preparedStatement2=connection.prepareStatement("UPDATE MANGA_APP.MANGA SET TITLE=?,DESCRIPTION=?,COVER_ID=? WHERE MANGA_ID=?;");
            if(manga.getMangaId()==0) {
                preparedStatement1.setString(1, manga.getTitle());
                preparedStatement1.setString(2, manga.getDescription());
                preparedStatement1.setInt(3, manga.getCoverId());
                preparedStatement1.executeUpdate();
            }
            else{
                preparedStatement2.setString(1,manga.getTitle());
                preparedStatement2.setString(2, manga.getDescription());
                preparedStatement2.setInt(3,manga.getCoverId());
                preparedStatement2.executeUpdate();
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