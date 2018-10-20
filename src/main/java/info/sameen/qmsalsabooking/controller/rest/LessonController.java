package info.sameen.qmsalsabooking.controller.rest;

import info.sameen.qmsalsabooking.model.Attendee;
import info.sameen.qmsalsabooking.model.Lesson;
import info.sameen.qmsalsabooking.service.LessonService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
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

    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    // Create
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody Lesson lesson) {
        lessonService.save(lesson);
    }

    // Retrieve
    @RequestMapping(value = "/retrieve", method = RequestMethod.GET)
    public List<Lesson> get() {
        return  lessonService.findAll();
    }

    @RequestMapping(value = "/retrieve/{lessonId}", method = RequestMethod.GET)
    public Lesson get(@PathVariable String lessonId) {
        return lessonService.findById(lessonId);
    }

    // Update
    @RequestMapping(value = "/update/{lessonId}", method = RequestMethod.POST)
    public Lesson update(@PathVariable String lessonId) {
        throw new NotYetImplementedException();
    }

    // Delete
    @RequestMapping(value = "/delete/{lessonId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String lessonId) {
        lessonService.delete(lessonId);
    }
}
