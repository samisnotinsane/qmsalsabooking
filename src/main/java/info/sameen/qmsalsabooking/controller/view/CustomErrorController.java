package info.sameen.qmsalsabooking.controller.view;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the error pages.
 * @author sameenislam
 * @version 1.0
 */
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String handleError() {
        return "error";
    }

    @RequestMapping(value = "/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
