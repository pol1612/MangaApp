package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.exceptions.CoverRepositoryDeleteException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.CoverRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;

import java.sql.SQLException;
import java.util.List;
public class CoverRepository implements RepositoriesDo <Cover,Integer> {
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
        public void delete (Cover cover){
            try (var connection=connectionManager.getConnection()){
                var preparedStatement = connection.prepareStatement("DELETE FROM MANGA_APP.COVER WHERE COVER_ID=?;");
                var cover_id = cover.getCoverId();
                preparedStatement.setInt(1, cover_id);
                preparedStatement.executeUpdate();

            }
            catch (SQLException e) {
                throw new CoverRepositoryDeleteException(e);
            }
    }

        //@Override
        public List<Cover> GetById ( int id){
        return null;
    }

        //@Override
        public List<Cover> GetAll () {
        return null;
    }
}
