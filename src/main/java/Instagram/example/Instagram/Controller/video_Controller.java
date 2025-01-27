package Instagram.example.Instagram.Controller;

import Instagram.example.Instagram.Service.video_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class video_Controller {
    @Autowired
    private video_Service videoService;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/video/upload")
    public ResponseEntity<?> videoUpload(@RequestParam("video") MultipartFile video) {
        try {
            Map<String, Object> result = videoService.upload(video);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading video: " + e.getMessage());
        }
    }
}
