package sing.services;

import org.springframework.stereotype.Service;
import sing.models.ListMusic;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListMusicService {
    List<ListMusic> listMusics = new ArrayList<>();

    public ListMusicService() {
        listMusics.add(new ListMusic(1,"nhạc buồn"));
        listMusics.add(new ListMusic(1,"nhạc vui"));
        listMusics.add(new ListMusic(1,"nhạc tữ tình"));
    }

    public List<ListMusic> getListMusics() {
        return listMusics;
    }
}
