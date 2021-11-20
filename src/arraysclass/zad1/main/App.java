package arraysclass.zad1.main;

import arraysclass.zad1.logic.Person;
import arraysclass.zad1.service.PersonDatabase;

public class App {

    public static void main(String[] args) {
        PersonDatabase databse = new PersonDatabase();
        databse.add(new Person("Jan", "Kowalski", "01112378954"));
        databse.add(new Person("Marek", "Nowak", "97051643279"));
        databse.add(new Person("Ewa", "Go", "87093143279"));
        Person person = databse.get(1);
        System.out.println(person);
        int size = databse.size();
        System.out.println("Size = " + size);
        databse.remove(new Person("Marek", "Nowak", "97051643279"));
        System.out.println(databse);
    }
}
