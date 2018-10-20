package info.sameen.qmsalsabooking.service;

import info.sameen.qmsalsabooking.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Data service for performing CRUD operations on an <code>Attendee</code>.
 * @author sameenislam
 * @version 1.0
 */
@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    public AttendeeService() {
    }

    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    // Create
    public void save(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    // Retrieve
    public List<Attendee> findAll() {
        List<Attendee> attendees = new ArrayList<>();
        attendeeRepository.findAll()
                .forEach(attendees::add);

        return attendees;
    }

    public Attendee findById(long id) {
        return attendeeRepository.findById(id).orElse(null);
    }

    // Update
    public void update(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    // Delete
    public void delete(long id) {
        attendeeRepository.deleteById(id);
    }

}
