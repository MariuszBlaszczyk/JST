package exceptions.zad2.model;

import java.util.Objects;

public class Participant {

    private String firstName;
    private String lastName;
    private String documentId; //np. pesel
    private int age;

    public Participant(String firstName, String lastName, String documentId, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentId = documentId;
        if (age <= 0) {
            throw new IllegalArgumentException("Age has to be positive number");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    public String getDocumentId() {
        return documentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return age == that.age && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(documentId, that.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, documentId, age);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", id: " + documentId + ", age: " + age;
    }
}
