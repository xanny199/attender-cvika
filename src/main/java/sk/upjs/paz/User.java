package sk.upjs.paz;

import java.time.LocalDate;

public record User(Long id,
                   String name,
                   String surname,
                   Gender gender,
                   LocalDate birthday,
                   Role role) {

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE,
    }

    public enum Role {
        UNKNOWN,
        GUEST,
        ADMIN,
        USER,
        TEACHER,
    }
}
