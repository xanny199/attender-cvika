package sk.upjs.paz;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    void computeGenderRatio_happyPath() {
        var userService = new UserService(List.of(
                new User(
                   1L,
                   "NAME1",
                   "SURNAME1",
                   User.Gender.FEMALE,
                   LocalDate.ofYearDay(2007,256),
                   User.Role.ADMIN
                ),
                new User(
                        2L,
                        "NAME2",
                        "SURNAME2",
                        User.Gender.MALE,
                        LocalDate.ofYearDay(2002,48),
                        User.Role.GUEST
                ),
                new User(
                        3L,
                        "NAME3",
                        "SURNAME3",
                        User.Gender.UNKNOWN,
                        LocalDate.ofYearDay(2004,107),
                        User.Role.TEACHER
                )
        ));

        var got = userService.computeGenderRatio();

        assertEquals(0.3333333333333333,got.boys());
        assertEquals(0.3333333333333333,got.girls());
        assertEquals(0.3333333333333333,got.unknown());
    }

    @org.junit.jupiter.api.Test
    void computeGenderRatio_empty() {
        var userService = new UserService(Collections.emptyList());
        var got = userService.computeGenderRatio();
        assertEquals(0.0,got.boys());
        assertEquals(0.0,got.girls());
        assertEquals(0.0,got.unknown());
    }

    @org.junit.jupiter.api.Test
    void computeGenderRatio_null() {
        var userService = new UserService(Collections.emptyList());
        var got = userService.computeGenderRatio();
        assertEquals(0.0,got.boys());
        assertEquals(0.0,got.girls());
        assertEquals(0.0,got.unknown());
    }
}