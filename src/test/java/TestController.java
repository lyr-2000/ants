import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author czd
 * @Date:createed in
 * @Version: V1.0
 */
@Controller
@RequestMapping(value = "test")
public class TestController {
    @RequestMapping(value = "/testv1",method = RequestMethod.GET)
    @ResponseBody
    public void test(HttpServletRequest request) {
        String path = request.getContextPath();
        System.out.println("path: " + path);
    }
}
