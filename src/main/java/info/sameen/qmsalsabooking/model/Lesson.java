package info.sameen.qmsalsabooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

/**
 * A salsa lesson.
 * @author sameenislam
 * @version 1.0
 */
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private LocalTime dateTime;
    private String venue;
    private String level;
    private boolean isMembersOnly;

    public Lesson() {
    }

    public Lesson(LocalTime dateTime, String venue, String level, boolean isMembersOnly) {
        this.dateTime = dateTime;
        this.venue = venue;
        this.level = level;
        this.isMembersOnly = isMembersOnly;
    }

    public LocalTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isMembersOnly() {
        return isMembersOnly;
    }

    public void setMembersOnly(boolean membersOnly) {
        isMembersOnly = membersOnly;
    }
}
