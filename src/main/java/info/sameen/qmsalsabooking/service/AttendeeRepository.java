package info.sameen.qmsalsabooking.service;

import info.sameen.qmsalsabooking.model.Attendee;
import org.springframework.data.repository.CrudRepository;

/**
 * Data service interface provided for Spring Framework, which
 * implements standard crud operations.
 *
 * Note: Create, Retrieve, Update, Delete operations are implemented
 * by CrudRepository superclass.
 * @author sameenislam
 * @version 1.0
 */
public interface AttendeeRepository extends CrudRepository<Attendee, Long> {
    Attendee findBySurnameAndFirstName(String surname, String firstname);
}
