package cat.uvic.teknos.m06.MangaApp.domain.modules;

import java.sql.Date;

public class Chapter {
    private int mangaId;
    private String mangaTitle;
    private int chapterId;
    private int cahpterNumber;
    private String chapterTitle;
    private Date dateOfUploading;

    public int getMangaId(){
        return mangaId;
    }

    public void setMangaId(int mangaId) {
        this.mangaId = mangaId;
    }

    public String getMangaTitle() {
        return mangaTitle;
    }

    public void setMangaTitle(String mangaTitle) {
        this.mangaTitle = mangaTitle;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getCahpterNumber() {
        return cahpterNumber;
    }

    public void setCahpterNumber(int cahpterNumber) {
        this.cahpterNumber = cahpterNumber;
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
