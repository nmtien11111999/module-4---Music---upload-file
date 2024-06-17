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


    public void update(int id, Song song) {
        int index = findById(id).getId();
        songs.set(index, song);
    }


    public void delete(int id) {
        songs.removeIf(customer -> customer.getId() == id);
    }


    public Song findById(int id) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getId() == id){
                return songs.get(i);
            }
        }
        return null;
    }
}
