package testdata;

import com.github.javafaker.Faker;

public class UserData {
    public static Faker faker = new Faker();

    public static String firstname = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().safeEmailAddress();
    public static String mobileNumber = "9274454680";
    public static String address = faker.address().fullAddress();
    public static String state = "NCR";
    public static String city = "Delhi";
    public static String subject = "Math";
    public static String gender = "Male";
    public static String hobby = "Sports";
    public static String path = "files/picture.jpeg";
}
