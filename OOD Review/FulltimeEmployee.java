package DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

public class FulltimeEmployee extends Person{
    private int salary;
    private String department;

    public FulltimeEmployee(String firstName, String lastName, int salary, String department) {
        super(firstName, lastName);
        this.salary = salary;
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String toString() {
        return super.toString() + ". Department " + department + ". Salary " + salary;
    }
}
