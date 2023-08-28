package DataStructuresAndAlgorithms;

import java.util.*;

public class AddressBook<E extends Person> {
    private ArrayList<E> book = new ArrayList<>();

    //this program uses default constructor

    public void addPerson(E person) {
        book.add(person);
    }

    public void deletePerson(int index) {
        book.remove(index);
    }

    //search for person based on ID
    public Person getPerson(int ID) {
        for (E person: book) {
            if (person.getID() == ID) {
                return person;
            }
        }
        return null;
    }
}
