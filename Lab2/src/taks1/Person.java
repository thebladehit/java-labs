package taks1;

import java.util.Objects;

public class Person {
    public String surName;
    public String name;
    public int age;

    public Person(String surName, String name, int age) {
        this.surName = surName;
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        if (age != person.age) return false;
        if (!Objects.equals(surName, person.surName)) return false;
        return Objects.equals(name, person.name);
    }
}
