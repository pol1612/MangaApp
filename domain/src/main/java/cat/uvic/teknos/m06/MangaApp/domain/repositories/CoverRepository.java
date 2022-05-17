package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionProperties;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
public class CoverRepository implements RepositoriesDo <Cover,Integer>{
    private final Connection connection;
    CoverRepository(Connection connection){
        this.connection=connection;
    }
    @Override
    public void save(Cover cover) {
    try{
        var preparedStatement1=connection.prepareStatement("INSERT INTO MANGA_APP.COVER VALUES(?,?,?);");
        var preparedStatement2=connection.prepareStatement("UPDATE MANGA_APP.COVER SET COVER_PATH=?,WIDTH=?, HEIGHT=? WHERE COVER_ID=?;");
        int cover_id=cover.getCoverId();
        String cover_path=cover.getCover_path();
        int width=cover.getWidth();
        int height=cover.getHeight();
        cover_path="'"+cover_path+"'";
        preparedStatement1.setString(1,cover_path);
        preparedStatement1.setInt(2,width);
        preparedStatement1.setInt(3,height);
        preparedStatement2.setString(1,cover_path);
        preparedStatement2.setInt(2,width);
        preparedStatement2.setInt(3,height);
        preparedStatement2.setInt(4,cover_id);
        if (cover_id==0){
            preparedStatement1.executeUpdate();
        }if(cover_id!=0){
            preparedStatement2.executeUpdate();
        }
    }catch (SQLException e){

    }
    }

    @Override
    public void delete(Cover cover) {

    }

    //@Override
    public List<Cover> GetById(int id) {
        return null;
    }

    //@Override
    public List<Cover> GetAll() {
        return null;
    }
}
