package cat.uvic.teknos.m06.MangaApp.domain.models;

public class Manga {
    private int mangaId;
    private String title;
    private String description;
    private int coverId;
    public int getMangaId() {
        return mangaId;
    }

    public void setMangaId(int mangaId) {
        this.mangaId = mangaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCoverId() {
        return coverId;
    }

    public void setCoverId(Cover c) {
        coverId=c.getCoverId();
    }


}
