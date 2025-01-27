package Instagram.example.Instagram.Service;

import Instagram.example.Instagram.Model.Video;
import Instagram.example.Instagram.Repository.video_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reels_Service {
    @Autowired
    private video_Repository videorepository;
    public List<Video> getVideo()
    {
        return videorepository.findAll();
    }
}
