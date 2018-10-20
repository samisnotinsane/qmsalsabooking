package info.sameen.qmsalsabooking.controller.rest;

import info.sameen.qmsalsabooking.exceptions.LessonNotFoundException;
import info.sameen.qmsalsabooking.model.Attendee;
import info.sameen.qmsalsabooking.model.Lesson;
import info.sameen.qmsalsabooking.service.LessonService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@RequestBody Lesson lesson) {
        lessonService.save(lesson);
    }

    // Retrieve
    @RequestMapping(value = "/retrieve", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Lesson> get() {
        return  lessonService.findAll();
    }

    @RequestMapping(value = "/retrieve/{lessonId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Lesson get(@PathVariable long lessonId) throws LessonNotFoundException {
        Lesson foundLesson = lessonService.findById(lessonId);
        if (foundLesson == null) {
            throw new LessonNotFoundException("Lesson with '" + lessonId + "' does not exist.");
        }
        return lessonService.findById(lessonId);
    }

    // Update
    @RequestMapping(value = "/update/{lessonId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@PathVariable long lessonId, @RequestBody Lesson lesson) throws LessonNotFoundException {
        Lesson foundLesson = lessonService.findById(lessonId);
        if (foundLesson == null) {
            throw new LessonNotFoundException("Lesson with '" + lessonId + "' does not exist.");
        }
        lesson.setId(lessonId);
        lessonService.update(lesson);
    }

    // Delete
    @RequestMapping(value = "/delete/{lessonId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long lessonId) throws LessonNotFoundException {
        Lesson foundLesson = lessonService.findById(lessonId);
        if (foundLesson == null) {
            throw new LessonNotFoundException("Lesson with '" + lessonId + "' does not exist.");
        }
        lessonService.delete(lessonId);
    }
}
