package DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

public class AddressBookTester {
    public static void main(String[] args) {
        FulltimeEmployee mikeManly = new FulltimeEmployee("Mike", "Manly", 10000, "Physics");
        FulltimeEmployee nathanNelson = new FulltimeEmployee("Nathan", "Nelson", 75000, "Chemistry");
        FulltimeEmployee chadChen = new FulltimeEmployee("Chad", "Chen", 50000, "English");

        AddressBook<FulltimeEmployee> book = new AddressBook<>();
        book.addPerson(mikeManly);
        book.addPerson(nathanNelson);
        book.addPerson(chadChen);

        System.out.println(book.getPerson(1003));
        System.out.println(book.getPerson(1002));
        System.out.println(book.getPerson(1001));
    }
}
