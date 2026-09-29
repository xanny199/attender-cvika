package sk.upjs.paz;

import java.util.List;

public class UserService {

    private final List<User> database;

    public UserService(List<User> database) {
        this.database = database;
    }

    public GenderRatio computeGenderRatio() {

        if(this.database == null || this.database.isEmpty()) {
            return new GenderRatio(0.0,0.0,0.0);
        }

        double boys = 0.0;
        double girlrs = 0.0;
        double unknown = 0.0;
        for (User user : database) {
            if (user.gender().equals(User.Gender.MALE)) boys++;
            if (user.gender().equals(User.Gender.FEMALE)) girlrs++;
            if(user.gender().equals(User.Gender.UNKNOWN)) unknown++;
        }
        double total = boys + girlrs + unknown;
        return new GenderRatio(boys/total, girlrs/total, unknown/total);
    }
}
