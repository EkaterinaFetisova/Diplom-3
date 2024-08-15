package data;
import org.apache.commons.lang3.RandomStringUtils;

public class UserRandomizer {
    public static User getNewRandomUser() {
        return new User(RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru",
                RandomStringUtils.randomAlphanumeric(6));
    }
}
