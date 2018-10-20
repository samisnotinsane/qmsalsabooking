package info.sameen.qmsalsabooking.service;

import info.sameen.qmsalsabooking.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Data service for performing CRUD operations on lessons.
 * @author sameenislam
 * @version 1.0
 */
@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public LessonService() {
    }

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    // Create
    public void save(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    // Retrieve
    public List<Lesson> findAll() {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findAll()
                .forEach(lessons::add);

        return lessons;
    }

    // Update

    // Delete

}
