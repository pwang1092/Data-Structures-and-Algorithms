package DataStructuresAndAlgorithms;


public class Person {
    private String firstName;
    private String lastName;
    private int ID;

    public static int IDCount = 1001;

    //constructors
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        ID = IDCount;
        IDCount++;
    }

    //getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public int getID() {
        return ID;
    }

    //methods to print
    public void printFirstName() {
        System.out.println(firstName);
    }

    public void printLastName() {
        System.out.println(lastName);
    }

    public void printID() {
        System.out.println(ID);
    }

    //toString override
    public String toString() {
        return lastName + ", " + firstName + ". ID " + ID;
    }

}

class personTester {
    public static void main(String[] args) {
        Person billSmith = new Person("Bill", "Smith");
        System.out.println(billSmith.toString());

        Person janeDoe = new Person("Jane", "Doe");
        System.out.print(janeDoe.getLastName() + " ");
        janeDoe.printID();
    }
}