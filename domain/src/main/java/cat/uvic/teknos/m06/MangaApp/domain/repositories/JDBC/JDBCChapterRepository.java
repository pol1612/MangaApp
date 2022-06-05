package cat.uvic.teknos.m06.MangaApp.domain.repositories.JDBC;

import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter.JDBCChapterRepositoryDeleteException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter.JDBCChapterRepositoryGetAllException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter.JDBCChapterRepositoryGetByIdException;
import cat.uvic.teknos.m06.MangaApp.domain.exceptions.JDBC.chapter.JDBCChapterRepositorySaveException;
import cat.uvic.teknos.m06.MangaApp.domain.helpers.ConnectionManager;
import cat.uvic.teknos.m06.MangaApp.domain.models.Chapter;
import cat.uvic.teknos.m06.MangaApp.domain.repositories.RepositoriesDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                preparedStatement.setDouble(2,chapter.getChapterNumber());
                preparedStatement.setString(3,chapter.getChapterTitle());
                preparedStatement.setDate(4,chapter.getDateOfUploading());
                preparedStatement.executeUpdate();
            }else{
                preparedStatement1.setInt(1,chapter.getMangaId());
                preparedStatement1.setDouble(2,chapter.getChapterNumber());
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
        try(Connection connection=connectionManager.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MANGA_APP.CHAPTER WHERE CHAPTER_ID=?;");
            Chapter chapter=new Chapter();
            ResultSet resultSet;
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            chapter.setChapterId(resultSet.getInt("CHAPTER_ID"));
            chapter.setMangaId(resultSet.getInt("MANGA_ID"));
            chapter.setChapterNumber(resultSet.getInt("CHAPTER_NUMBER"));
            chapter.setChapterTitle(resultSet.getString("CHAPTER_TITLE"));
            chapter.setDateOfUploading(resultSet.getDate("DATE_OF_UPLOADING"));
            return chapter;

        }
        catch (SQLException e){
            throw new JDBCChapterRepositoryGetByIdException(e);
        }
    }

    @Override
    public List<Chapter> GetAll() {
        try(Connection connection= connectionManager.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MANGA_APP.CHAPTER;");
            List<Chapter> chapterList=new ArrayList<>();
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Chapter chapter=new Chapter();
                chapter.setChapterId(resultSet.getInt("CHAPTER_ID"));
                chapter.setChapterTitle(resultSet.getString("CHAPTER_TITLE"));
                chapter.setMangaId(resultSet.getInt("MANGA_ID"));
                chapter.setChapterNumber(resultSet.getInt("CHAPTER_NUMBER"));
                chapter.setDateOfUploading(resultSet.getDate("DATE_OF_UPLOADING"));
                chapterList.add(chapter);
            }
            return chapterList;
        }
        catch (SQLException e){
            throw new JDBCChapterRepositoryGetAllException(e);
        }
    }
}
