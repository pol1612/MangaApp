package cat.uvic.teknos.m06.MangaApp.domain.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Chapter {

    private int mangaId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapterId;
    private double chapterNumber;
    private String chapterTitle;
    private Date dateOfUploading;

    public int getMangaId(){
        return mangaId;
    }

    public void setMangaId(int mangaId) {
      this.mangaId=mangaId;
    }
    

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public double getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(double chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public Date getDateOfUploading() {
        return dateOfUploading;
    }

    public void setDateOfUploading(Date dateOfUploading) {
        this.dateOfUploading = dateOfUploading;
    }

}
