package info.sameen.qmsalsabooking.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the index page.
 * @author sameenislam
 * @version 1.0
 */
@Controller
public class RegistrationController {

    @GetMapping("/signup")
    public String register(Model model) {
        model.addAttribute("title", "QM Salsa Society");
        return "signup";
    }
}
