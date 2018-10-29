package info.sameen.qmsalsabooking.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the lessons page.
 * @author sameenislam
 * @version 1.0
 */
@Controller
public class LessonViewController {

    @GetMapping("/lessons")
    public String lessons() {
        return "lessons";
    }
}
