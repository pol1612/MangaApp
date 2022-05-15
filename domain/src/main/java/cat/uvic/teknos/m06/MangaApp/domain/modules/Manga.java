package cat.uvic.teknos.m06.MangaApp.domain.modules;

import java.util.ArrayList;
import java.util.List;

public class Manga {
    private int mangaId;
    private String title;
    private String description;
    private int coverId;
    private List<Genre> genres= new ArrayList<>();

    public void setCoverId(int coverId) {
        this.coverId = coverId;
    }

    public int getCoverId() {
        return coverId;
    }
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

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

    public void setCoverId(Cover c) {
        coverId=c.getCoverId();
    }
    public void AddGenre(Genre g){
        genres.add(g);
    }
    public void RemoveGenre(Genre g){
        genres.remove(g);
    }
}
