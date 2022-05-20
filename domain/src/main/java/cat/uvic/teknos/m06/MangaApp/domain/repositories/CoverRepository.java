package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositoryDeleteException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositoryGetByIdException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;

import java.sql.SQLException;
import java.util.List;
public class CoverRepository implements RepositoriesDo <Cover> {
    private final ConnectionManager connectionManager;

        public CoverRepository(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public void save (Cover cover){
        try (var connection=connectionManager.getConnection()){
            var preparedStatement1 = connection.prepareStatement("INSERT INTO MANGA_APP.COVER (COVER_PATH,HEIGHT,WIDTH) VALUES(?, ?, ?);");
            var preparedStatement2 = connection.prepareStatement("UPDATE MANGA_APP.COVER SET COVER_PATH=?, WIDTH=?, HEIGHT=? WHERE COVER_ID=?;");
            var cover_id = cover.getCoverId();
            String cover_path = cover.getCover_path();
            var width = cover.getWidth();
            var height = cover.getHeight();
            cover_path = "'" + cover_path + "'";
            preparedStatement1.setString(1, cover_path);
            preparedStatement1.setInt(2, width);
            preparedStatement1.setInt(3, height);
            preparedStatement2.setString(1, cover_path);
            preparedStatement2.setInt(2, width);
            preparedStatement2.setInt(3, height);
            preparedStatement2.setInt(4, cover_id);
            if (cover_id == 0) {
                preparedStatement1.executeUpdate();
            }
            if (cover_id != 0) {
                preparedStatement2.executeUpdate();
            }
        }
        catch (SQLException e) {
            throw new CoverRepositorySaveException(e);
        }
    }

    @Override
    public void delete (Integer cover_id){
        try (var connection=connectionManager.getConnection()){
            var preparedStatement = connection.prepareStatement("DELETE FROM MANGA_APP.COVER WHERE COVER_ID=?;");
            preparedStatement.setInt(1, cover_id);
            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new CoverRepositoryDeleteException(e);
        }
    }

    @Override
    public Cover GetById ( Integer id){
        try(var connection=connectionManager.getConnection()){
            var preparedStatement=connection.prepareStatement("SELECT * FROM COVER WHERE COVER_ID=?;");
            var resultSet=preparedStatement.executeQuery();
            Cover cover=new Cover();
            var cover_id=resultSet.getInt("cover_id");
            var cover_path=resultSet.getString("cover_path");
            var width=resultSet.getInt("width");
            var height=resultSet.getInt("height");
            cover.setCoverId(cover_id);
            cover.setCover_path(cover_path);
            cover.setWidth(width);
            cover.setHeight(height);
            return cover;
        }
        catch (SQLException e){
            throw  new CoverRepositoryGetByIdException(e);
        }

    }

    //@Override
    public List<Cover> GetAll () {
    return null;
    }

}
