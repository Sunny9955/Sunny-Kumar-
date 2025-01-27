package Instagram.example.Instagram.Repository;

import Instagram.example.Instagram.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface video_Repository extends JpaRepository<Video,Long> {

}
