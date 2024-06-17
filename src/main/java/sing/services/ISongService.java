package sing.services;

import sing.models.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void addMusic(Song song);
    void update(int id, Song song);
    void delete(int id);
    Song findById(int id);
}
