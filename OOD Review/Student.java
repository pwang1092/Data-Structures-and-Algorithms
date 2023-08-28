package DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

public class Student extends Person{
    private ArrayList<String> classesTaken = new ArrayList<>();
    private ArrayList<Character> grades = new ArrayList<>();

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void addClass(String className, char grade) {
        classesTaken.add(className);
        grades.add(grade);
    }

    public void printTranscript() {
        System.out.println(super.toString());
        for (int i = 0; i < classesTaken.size(); i++) {
            System.out.println(classesTaken.get(i) + " " + grades.get(i));
        }
    }

    public ArrayList<String> getClassesTaken() {
        return classesTaken;
    }

    public ArrayList<Character> getGrades() {
        return grades;
    }

    public void deleteClass(int index) {
        classesTaken.remove(index);
        grades.remove(index);
    }
}
