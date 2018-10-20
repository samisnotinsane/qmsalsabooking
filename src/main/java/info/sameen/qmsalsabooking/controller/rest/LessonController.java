package info.sameen.qmsalsabooking.controller.rest;

import info.sameen.qmsalsabooking.model.Attendee;
import info.sameen.qmsalsabooking.model.Lesson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for performing CRUD operations on salsa lessons.
 * @author sameenislam
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/lesson")
public class LessonController {

    // Create
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Lesson> create(@RequestBody Lesson lesson) {
        // persist to db.
        return null;
    }

    // Retrieve
    @RequestMapping(value = "/retrieve", method = RequestMethod.GET)
    public List<Lesson> get() {
        return null;
    }

    @RequestMapping(value = "/retrieve/{lessonId}", method = RequestMethod.GET)
    public Lesson get(@PathVariable int lessonId) {
        return null;
    }

    // Update
    @RequestMapping(value = "/update/{lessonId}", method = RequestMethod.POST)
    public Lesson update(@PathVariable int lessonId) {
        return null;
    }

    // Delete
    @RequestMapping(value = "/delete/{lessonId}", method = RequestMethod.DELETE)
    public List<Lesson> delete(@PathVariable int lessonId) {
        return null;
    }
}
