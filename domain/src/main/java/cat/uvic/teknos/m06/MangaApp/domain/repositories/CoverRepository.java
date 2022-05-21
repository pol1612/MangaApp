package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositoryDeleteException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositoryGetAllException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositoryGetByIdException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.cover.CoverRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;
import jdk.swing.interop.SwingInterOpUtils;

import java.sql.*;
import java.util.ArrayList;
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
            if (cover_id == 0) {
                preparedStatement1.setString(1, cover_path);
                preparedStatement1.setInt(2, width);
                preparedStatement1.setInt(3, height);
                preparedStatement1.executeUpdate();
            }
            else {
                preparedStatement2.setString(1, cover_path);
                preparedStatement2.setInt(2, width);
                preparedStatement2.setInt(3, height);
                preparedStatement2.setInt(4, cover_id);
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
        System.out.println(id);
        try(var connection=connectionManager.getConnection()){
            Cover cover=new Cover();
            var preparedStatement=connection.prepareStatement("SELECT * FROM MANGA_APP.COVER WHERE COVER_ID=?;");
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            var cover_id = resultSet.getInt("COVER_ID");
            var cover_path = resultSet.getString("COVER_PATH");
            var width = resultSet.getInt("WIDTH");
            var height = resultSet.getInt("HEIGHT");
            System.out.println(123456);
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

    @Override
    public List<Cover> GetAll () {
        try(Connection connection= connectionManager.getConnection()){
            List<Cover> list= new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql="SELECT * FROM MANGA_APP.COVER;";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Cover cover= new Cover();
                cover.setCoverId(resultSet.getInt("COVER_ID"));
                cover.setCover_path(resultSet.getString("COVER_PATH"));
                cover.setHeight(resultSet.getInt("HEIGHT"));
                cover.setWidth(resultSet.getInt("WIDTH"));
                list.add(cover);
            }
            return list;
        }catch (SQLException e){
            throw new CoverRepositoryGetAllException(e);
        }
    }

}
