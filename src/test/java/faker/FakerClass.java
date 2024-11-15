package faker;

import com.github.javafaker.Faker;

public class FakerClass {
    public static String fakeNumber (){
        return new Faker().number().digits(5);
    }
    public static String fakeWord (){
        return new Faker().regexify("[a-zA-Z]{8}");
    }
}
