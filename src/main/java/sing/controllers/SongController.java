package sing.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sing.models.Song;
import sing.models.SongForm;
import sing.services.ISongService;
import sing.services.ListMusicService;
import sing.services.SongService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private ISongService productService;

    @Autowired
    private ListMusicService musicService;

    @GetMapping("/list")
    public String showAll(Model model) {
        List<Song> songs = productService.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("songForm", new SongForm());
        modelAndView.addObject("lists", musicService.getListMusics());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute SongForm songForm) {
        // lấy ảnh ra
        MultipartFile multipartFile = songForm.getFileSong();
        // lấy tên file
        String fileName = multipartFile.getOriginalFilename();
        try {
            // copy lại file ến nơi lưu trữ
            FileCopyUtils.copy(songForm.getFileSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(),
                songForm.getArtist(),songForm.getListMusic() , fileName);
        productService.addMusic(song);
        return "redirect:/song/list";
    }
}