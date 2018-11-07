package info.sameen.qmsalsabooking.component;

import info.sameen.qmsalsabooking.model.Lesson;
import info.sameen.qmsalsabooking.service.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Loads data into Lessons repository upon startup.
 * @author sameenislam
 * @version 1.0
 */
@Component
public class LessonDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(LessonDataLoader.class);

    private LessonService lessonRepository;

    public LessonDataLoader(LessonService lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading dummy lessons data");

        lessonRepository.save(
                new Lesson(
                        "15/11/2018",
                        "6:30 PM",
                        "7:30 PM",
                        "Active Studio",
                        "Beginners",
                        "Everyone",
                        7.00)
        );

        lessonRepository.save(
                new Lesson(
                        "20/11/2018",
                        "7:30 PM",
                        "8:30 PM",
                        "Arts Two LT",
                        "Improvers",
                        "Members",
                        5.00)
        );

        lessonRepository.save(
                new Lesson(
                        "22/11/2018",
                        "6:30 PM",
                        "7:30 PM",
                        "Active Studio",
                        "Beginners",
                        "Everyone",
                        7.00)
        );


    }
}
