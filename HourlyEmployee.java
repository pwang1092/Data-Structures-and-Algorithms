package DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

public class HourlyEmployee extends Person{
    private String department;
    private double hourlyRate;
    private ArrayList<Double> hoursPerWeek = new ArrayList<>();

    public HourlyEmployee(String firstName, String lastName, double hourlyRate, String department) {
        super(firstName, lastName);
        this.department = department;
        this.hourlyRate = hourlyRate;
    }

    public void updateWeeklyHours(Double hours) {
        hoursPerWeek.add(hours);
    }

    public double totalHours() {
        double fourWeekTotal = 0;
        for (int i = hoursPerWeek.size()-1; i >= hoursPerWeek.size()-4 && i >= 0; i--) {
            fourWeekTotal += hoursPerWeek.get(i);
        }
        return fourWeekTotal;
    }

    public double averageHours() {
        double sum = 0;
        for (Double n: hoursPerWeek) {
            sum += n;
        }
        return sum / hoursPerWeek.size();
    }

    public double totalWages() {
        return totalHours() * hourlyRate;
    }

    public String toString() {
        return super.toString() + ". Hourly wage " + hourlyRate + ". Department " + department;
    }
}
