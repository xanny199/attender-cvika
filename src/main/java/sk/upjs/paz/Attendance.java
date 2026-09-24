package sk.upjs.paz;

import java.time.LocalDate;
import java.util.List;

public record Attendance(Long id,
                         LocalDate date,
                         Subject subject,
                         List<User> attendees) {
}
