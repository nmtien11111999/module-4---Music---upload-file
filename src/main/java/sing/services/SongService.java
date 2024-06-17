package sing.services;

import org.springframework.stereotype.Service;
import sing.models.Song;

import java.util.ArrayList;
import java.util.List;


@Service
public class SongService implements ISongService {
    List<Song> songs = new ArrayList<Song>();

    public List<Song> findAll() {
        return songs;
    }


    public void addMusic(Song song) {
        songs.add(song);
    }


    public void update(int id, Song music) {
        int index = songs.indexOf(findById(id));
        songs.set(index, music);
    }


    public void delete(int id) {
        songs.remove(id);
    }


    public Song findById(int id) {
        return songs.get(id);
    }
}
