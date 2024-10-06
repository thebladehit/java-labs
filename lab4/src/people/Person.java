package people;

public class Person {
    private final String name;
    private final PersonType type;

    public Person(String name, PersonType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " " + type;
    }
}
