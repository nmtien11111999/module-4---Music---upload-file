package sing.models;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id;
    private String name;
    private String artist;
    private ListMusic listMusic;
    private MultipartFile fileSong;

    public SongForm(){

    }

    public SongForm(int id, String name, String artist, ListMusic listMusic, MultipartFile fileSong) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.listMusic = listMusic;
        this.fileSong = fileSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ListMusic getListMusic() {
        return listMusic;
    }

    public void setListMusic(ListMusic listMusic) {
        this.listMusic = listMusic;
    }

    public MultipartFile getFileSong() {
        return fileSong;
    }

    public void setFileSong(MultipartFile fileSong) {
        this.fileSong = fileSong;
    }
}
