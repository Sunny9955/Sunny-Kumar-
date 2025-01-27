package Instagram.example.Instagram.Service;

import Instagram.example.Instagram.Model.Video;
import Instagram.example.Instagram.Repository.video_Repository;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class video_Service {
    @Autowired
    private video_Repository videoRepository;
    @Autowired
    private Cloudinary cloudinary;

    public Map<String, Object> upload(MultipartFile video) {
        try {
//            String originalFilename = video.getOriginalFilename();
            byte[] bytes = video.getBytes();
            Map<String, Object> uploadResult = cloudinary.uploader().upload(bytes, Map.of("resource_type", "video"));

            String videoUrl = (String) uploadResult.get("url");

            Video v = Video.builder()
                    .videoUrl(videoUrl)
                    .build();
            videoRepository.save(v);

            return uploadResult;

        } catch (IOException e) {
            throw new RuntimeException("Video could not be uploaded", e);
        }
    }
}

