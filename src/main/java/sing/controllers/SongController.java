package sing.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sing.models.Song;
import sing.models.SongForm;
import sing.services.ISongService;
import sing.services.ListMusicService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @Autowired
    private ListMusicService listMusicService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/list")
    public String showAll(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songForm", new SongForm());
        model.addAttribute("lists", listMusicService.getListMusics());
        return "create";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute("songForm") SongForm songForm) {
        MultipartFile multipartFile = songForm.getFileSong();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getFileSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(),
                songForm.getArtist(), songForm.getListMusic(), fileName);
        songService.addMusic(song);
        return "redirect:/song/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Song song = songService.findById(id);
        SongForm songForm = new SongForm(song.getId(), song.getName(), song.getArtist(), song.getListMusic(), null);
        model.addAttribute("songForm", songForm);
        model.addAttribute("lists", listMusicService.getListMusics());
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@ModelAttribute("songForm") SongForm songForm) {
        MultipartFile multipartFile = songForm.getFileSong();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getFileSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getArtist(), songForm.getListMusic(), fileName);
        songService.update(songForm.getId(), song);
        return "redirect:/song/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        songService.delete(id);
        return "redirect:/song/list";
    }
}
