package java_stream;

import java.util.ArrayList;
import java.util.Comparator;

public class PersonManager {
    private ArrayList<Person> persons;
    public PersonManager() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person p) {
        // kiem tra p co ton tai trong array
        boolean existedPerson = this.persons.stream().anyMatch(person -> person.getId() == p.getId());
        if (existedPerson) return;
        this.persons.add(p);
    }

    public ArrayList<Person> findPersonByAge(int age) {
        // loc ra person co age == age
        return (ArrayList<Person>) this.persons.stream().filter(person -> person.getAge() == age).toList();
    }

    public ArrayList<Person> sortPersonByAge() {
        // xap xep person dua tren age
        return (ArrayList<Person>) this.persons.stream().sorted(Comparator.comparingInt(Person::getAge)).toList();
    }

    public ArrayList<Person> getPersons() { return this.persons; }
}
