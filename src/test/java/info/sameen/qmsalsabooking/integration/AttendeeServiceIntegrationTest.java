package info.sameen.qmsalsabooking.integration;

import info.sameen.qmsalsabooking.model.Attendee;
import info.sameen.qmsalsabooking.service.AttendeeRepository;
import info.sameen.qmsalsabooking.service.AttendeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sameen on 2019-01-27.
 */
@RunWith(SpringRunner.class)
public class AttendeeServiceIntegrationTest {

    @TestConfiguration
    static class AttendeeServiceTestContextConfiguration {

        @Bean
        public AttendeeService attendeeService() {
            return new AttendeeService();
        }
    }

    @Autowired
    private AttendeeService attendeeService;

    @MockBean
    private AttendeeRepository attendeeRepository;

    @Before
    public void setUp() {
        Attendee carolina = new Attendee("Carolina", "Soares", "female", "improver",
                "member", "carolina.soares@qmul.ac.uk", "fakepassword123");

        Mockito.when(attendeeRepository.findBySurnameAndFirstName("Soares", "Carolina"))
                .thenReturn(carolina);
    }

    @Test
    public void whenValidName_thenAttendeeShouldBeFound() {
        String firstName = "Carolina";
        String surname = "Soares";
        Attendee found = attendeeService.findBySurnameAndFirstName(surname, firstName);

        assertThat(found.getFirstName())
                .isEqualTo(firstName);
    }
}
