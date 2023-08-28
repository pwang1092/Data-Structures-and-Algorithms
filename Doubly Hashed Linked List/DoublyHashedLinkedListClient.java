package DataStructuresAndAlgorithms;

import java.util.*;

public class DoublyHashedLinkedListClient {
    public static void main(String[] args) throws Exception {
        DoublyHashedLinkedList<String, String, StudentRecord> records = new DoublyHashedLinkedList<>();
        StudentRecord adam = new StudentRecord("Adam", "Smith", 100, "01/25/2005");
        StudentRecord john = new StudentRecord("John", "Doe", 101, "04/17/2006");
        StudentRecord david = new StudentRecord("David", "Goliath", 102, "09/02/2007");
        StudentRecord david2 = new StudentRecord("David", "Goliath", 102, "09/02/2007");
        StudentRecord differentDavid = new StudentRecord("David", "Goliath", 103, "11/02/2007");

        System.out.println("Add student records: ");

        records.add(adam.getKey1(), adam.getKey2(), adam);
        print(records.getList());
        System.out.println();

        records.add(john.getKey1(), john.getKey2(), john);
        print(records.getList());
        System.out.println();

        records.add(david.getKey1(), david.getKey2(), david);
        print(records.getList());
        System.out.println();

        System.out.println("David is updated (can be seen in changed random data field)");
        records.add(david2.getKey1(), david.getKey2(), david2);
        print(records.getList());
        System.out.println();

        records.add(differentDavid.getKey1(), differentDavid.getKey2(), differentDavid);
        print(records.getList());
        System.out.println();

        records.remove(john.getKey1(), john.getKey2(), john);
        print(records.getList());
        System.out.println();

        System.out.println("Records with name David: ");
        LinkedList<StudentRecord> recordsWithName = getByName(records.getList(), "David");
        print(recordsWithName);
        System.out.println();

        System.out.println("Accessing using keys and hashtable");
        records.getByKey1("100").print();
    }

    public static LinkedList<StudentRecord> getByName(LinkedList<StudentRecord> list, String name) {
        LinkedList<StudentRecord> listOfRecords = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirstName().contains(name) || list.get(i).getLastName().contains(name)) {
                listOfRecords.add(list.get(i));
            }
        }
        return listOfRecords;
    }

    public static void print(LinkedList<StudentRecord> list) {
        for (StudentRecord stn: list) {
            stn.print();
        }
    }
}

class StudentRecord {
    private String firstName;
    private String lastName;
    private int studentID;
    private String dateOfBirth;
    private String data;

    String key1;
    String key2;

    public StudentRecord(String firstName, String lastName, int studentID, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.dateOfBirth = dateOfBirth;
        this.data = randomString();

        key1 = "" + studentID;
        key2 = dateOfBirth + ", " + firstName + " " + lastName;
    }

    private String randomString() {
        int randomLength = (int) (Math.random()*10) + 1; // between 1 and 10 inclusive
        String str = "";
        for (int i = 0; i < randomLength; i++) {
            str += (char) ((int)(Math.random() * 26) + 97); //random letter between a to z inclusive
        }
        return str;
    }

    public String getKey1() {
        return key1;
    }

    public String getKey2() {
        return key2;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void print() {
        System.out.println(key1 + ", " + key2 + ", " + data);
    }
}