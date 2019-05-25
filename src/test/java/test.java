import com.ants.entity.Announcement;
import com.ants.service.AnnouncementService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author czd
 */
public class test {
    @Autowired
    private AnnouncementService announcementService;

    @Test
    public void test(){
        Announcement announcement = announcementService.latestAnnouncement();
        System.out.println(announcement);

    }
}
