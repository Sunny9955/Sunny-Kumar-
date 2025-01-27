package Instagram.example.Instagram.Controller;

import Instagram.example.Instagram.Model.Video;
import Instagram.example.Instagram.Service.Reels_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Reels_Controller {
    @Autowired
    private Reels_Service reelsService;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/reels")
    public List<Video> getvideo()
    {
        return reelsService.getVideo();
    }
}
