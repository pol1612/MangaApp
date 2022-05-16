package cat.uvic.teknos.m06.MangaApp.domain.repositories;

import cat.uvic.teknos.m06.MangaApp.domain.modules.Cover;

import java.sql.Connection;
import java.sql.SQLException;

public class CoverRepository implements RepositoriesDo{
    private Connection connection;
    private Cover cover;
    CoverRepository(Connection connection, Cover cover){
        this.connection=connection;
        this.cover=cover;
    }
    @Override
    public void save() {
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
    public void delete() {

    }

    @Override
    public void GetById() {

    }

    @Override
    public void GetAll() {

    }
}
