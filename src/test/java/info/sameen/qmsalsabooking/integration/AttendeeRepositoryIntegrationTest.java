package info.sameen.qmsalsabooking.integration;

import info.sameen.qmsalsabooking.model.Attendee;
import info.sameen.qmsalsabooking.service.AttendeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by sameen on 2019-01-27.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AttendeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    AttendeeRepository attendeeRepository;

    @Test
    public void whenFindByName_thenReturnAttendee() {
        // given
        Attendee carolina = new Attendee("Carolina", "Soares", "female", "improver",
                "member", "carolina.soars@qmul.ac.uk", "fakepassword123");

        // when
        Attendee found = attendeeRepository.findBySurnameAndFirstName(carolina.getSurname(), carolina.getSurname());

        // then
        assertEquals(carolina, found);

    }

}
