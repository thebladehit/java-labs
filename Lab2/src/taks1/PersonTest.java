package taks1;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void classEquals() {
        Person p1 = new Person("John", "Drake", 12);

        Gson gson = new Gson();
        String p1JsonString = gson.toJson(p1);

        Person p2 = gson.fromJson(p1JsonString, Person.class);

        assertTrue(p1.equals(p2), "Persons is not equal");
    }

    @Test
    void classInNotEquals() {
        Person p1 = new Person("John", "Drake", 12);
        Person p2 = new Person("John", "Drake", 20);

        Gson gson = new Gson();
        String p1JsonString = gson.toJson(p1);

        Person p3 = gson.fromJson(p1JsonString, Person.class);

        assertFalse(p2.equals(p3), "Persons is equal");
    }
}