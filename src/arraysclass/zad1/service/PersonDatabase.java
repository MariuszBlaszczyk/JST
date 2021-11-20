package arraysclass.zad1.service;

import arraysclass.zad1.logic.Person;

import java.util.Arrays;

public class PersonDatabase {
    private static final int INITIAL_CAPACITY = 1;
    private int emptyPlace = 0;
    private Person[] people = new Person[INITIAL_CAPACITY];

    public void add(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if (emptyPlace == people.length) {
            people = Arrays.copyOf(people, people.length * 2);
        }
        people[emptyPlace] = person;
        emptyPlace++;
    }

    public  void remove(Person person) {
        if (person == null)
            throw new NullPointerException("person cannot be null");
        final int notFound = -1;
        int foundIndex = notFound;
        for (int i = 0; i < emptyPlace && foundIndex == notFound; i++) {
            if (person.equals(people[i])) {
                foundIndex = i;
            }
        }
        if (foundIndex != notFound) {
            System.arraycopy(people, foundIndex + 1, people, foundIndex, people.length - foundIndex - 1);
            emptyPlace--;
            people[emptyPlace] = null;
        }
    }

    public Person get(int index) {
        if (index >= emptyPlace || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index has to be positive and lower than " + emptyPlace);
        }
        return people[index];
    }

    public int size() {
        return emptyPlace;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonDatabase size: ");
        sb.append(emptyPlace);
        sb.append("\n");
        for (int i = 0; i < emptyPlace; i++) {
            sb.append(" > ");
            sb.append(people[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
