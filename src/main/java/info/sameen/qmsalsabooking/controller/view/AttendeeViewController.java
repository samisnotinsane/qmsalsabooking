package info.sameen.qmsalsabooking.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the attendee page.
 * @author sameenislam
 * @version 1.0
 */
@Controller
public class AttendeeViewController {

    @GetMapping("/attendees")
    public String attendees() {
        return "attendees";
    }
}
