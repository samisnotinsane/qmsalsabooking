package info.sameen.qmsalsabooking.component;

import info.sameen.qmsalsabooking.model.Attendee;
import info.sameen.qmsalsabooking.service.AttendeeService;
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
public class AttendeeDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(AttendeeDataLoader.class);

    private AttendeeService attendeeRepository;

    public AttendeeDataLoader(AttendeeService attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading attendee data");

        /* Personas were generated using:
         * https://www.fakenamegenerator.com/gen-random-en-uk.php
         */

        attendeeRepository.save(
                new Attendee(
                        "Lucas",
                        "Collier",
                        "Male",
                        "Beginner",
                        "Non-Member",
                        "LucasCollier@jourrapide.com",
                        "no2Ool4see"
                )
        );

        attendeeRepository.save(
                new Attendee(
                        "Alisha",
                        "Mann",
                        "Female",
                        "Improver",
                        "Member",
                        "AlishaMann@rhyta.com",
                        "UpeJoot4ph"
                )
        );

        attendeeRepository.save(
                new Attendee(
                        "Anna",
                        "McCarthy",
                        "Female",
                        "Beginner",
                        "Member",
                        "AnnaMcCarthy@jourrapide.com",
                        "Thee4Aik"
                )
        );
    }
}
