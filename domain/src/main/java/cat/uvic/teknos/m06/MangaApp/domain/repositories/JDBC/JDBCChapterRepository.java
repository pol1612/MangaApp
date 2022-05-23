package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC;

import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter.JDBCChapterRepositoryDeleteException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter.JDBCChapterRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.modules.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBCChapterRepository implements RepositoriesDo<Chapter,Integer> {
    private final ConnectionManager connectionManager;

    public JDBCChapterRepository(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public void save(Chapter chapter) {
        try(Connection connection= connectionManager.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO MANGA_APP.CHAPTER (MANGA_ID,CHAPTER_NUMBER,CHAPTER_TITLE,DATE_OF_UPLOADING) VALUES(?,?,?,?);");
            PreparedStatement preparedStatement1=connection.prepareStatement("UPDATE MANGA_APP.CHAPTER SET MANGA_ID=?,CHAPTER_NUMBER=?,CHAPTER_TITLE=?,DATE_OF_UPLOADING=? WHERE CHAPTER_ID=?;");
            if(chapter.getChapterId()==0){
                preparedStatement.setInt(1,chapter.getMangaId());
                preparedStatement.setInt(2,chapter.getChapterNumber());
                preparedStatement.setString(3,chapter.getChapterTitle());
                preparedStatement.setDate(4,chapter.getDateOfUploading());
                preparedStatement.executeUpdate();
            }else{
                preparedStatement1.setInt(1,chapter.getMangaId());
                preparedStatement1.setInt(2,chapter.getChapterNumber());
                preparedStatement1.setString(3,chapter.getChapterTitle());
                preparedStatement1.setDate(4,chapter.getDateOfUploading());
                preparedStatement1.setInt(5,chapter.getChapterId());
                preparedStatement1.executeUpdate();
            }

        }
        catch (SQLException e){
            throw new JDBCChapterRepositorySaveException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection connection=connectionManager.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM MANGA_APP.CHAPTER WHERE CHAPTER_ID=?;");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new JDBCChapterRepositoryDeleteException(e);
        }
    }

    @Override
    public Chapter GetById(Integer id) {
        return null;
    }

    @Override
    public List<Chapter> GetAll() {
        return null;
    }
}
