package sing.models;

public class Song {
    private int id;
    private String name;
    private String artist;
    private ListMusic listMusic;
    private String fileSong;

    public Song(){}
    public Song(int id, String name, String artist, ListMusic listMusic, String fileSong) {
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

    public String getFileSong() {
        return fileSong;
    }

    public void setFileSong(String fileSong) {
        this.fileSong = fileSong;
    }
}
