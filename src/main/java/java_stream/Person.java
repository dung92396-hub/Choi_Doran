package java_stream;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private int id;
    private LocalDate birthday;

    public Person(String firstName, String lastName, int id, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Full name: ")
                .append(this.getFullName()).append("\n")
                .append("Id: ").append(this.id).append("\n")
                .append("Birthday: ").append(this.birthday.toString()).append("\n");
        return sb.toString();
    }

    public String getFullName() { return this.firstName + " " + this.lastName; }

    public int getAge() {
        return LocalDate.now().getYear() - this.birthday.getYear();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
