package info.sameen.qmsalsabooking.controller.rest;

import info.sameen.qmsalsabooking.exceptions.AttendeeNotFoundException;
import info.sameen.qmsalsabooking.model.Attendee;
import info.sameen.qmsalsabooking.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for performing CRUD operations on an <code>Attendee</code>.
 * @author sameenislam
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/attendee")
public class AttendeeController {

    private AttendeeService attendeeService;

    public AttendeeController() {
    }

    @Autowired
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    // Create
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Attendee attendee) {
        attendeeService.save(attendee);
    }

    // Retrieve
    @RequestMapping(value = "/retrieve", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Attendee> get() {
        return attendeeService.findAll();
    }

    @RequestMapping(value = "retrieve/{attendeeId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Attendee get(@PathVariable long attendeeId) throws AttendeeNotFoundException {
        Attendee foundAttendee = attendeeService.findById(attendeeId);
        if (foundAttendee == null) {
            throw new AttendeeNotFoundException("Attendee with '" + attendeeId + "' does not exist.");
        }
        return attendeeService.findById(attendeeId);
    }

    // Update
    @RequestMapping(value = "/update/{attendeeId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void update(@PathVariable long attendeeId, @RequestBody Attendee attendee) throws AttendeeNotFoundException {
        Attendee foundAttendee = attendeeService.findById(attendeeId);
        if (foundAttendee == null) {
            throw new AttendeeNotFoundException("Attendee with '" + attendeeId + "' does not exist.");
        }
        attendee.setId(attendeeId);
        attendeeService.update(attendee);
    }

    // Delete
    @RequestMapping(value = "/delete/{attendeeId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void delete(@PathVariable long attendeeId) throws AttendeeNotFoundException {
        Attendee foundAttendee = attendeeService.findById(attendeeId);
        if (foundAttendee == null) {
            throw new AttendeeNotFoundException("Attendee with '" + attendeeId + "' does not exist.");
        }
        attendeeService.delete(attendeeId);
    }

}
