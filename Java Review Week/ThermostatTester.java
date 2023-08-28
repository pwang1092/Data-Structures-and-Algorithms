package DataStructuresAndAlgorithms;

import java.util.*;

public class ThermostatTester {
    public static void main(String[] args) {
        Thermostat t = new Thermostat(0, 100);

        try {
            t.setTemp(50);
            System.out.println("Temp set to " + t.getTemperature());
        }
        catch (TempOutOfRangeException ex) {
            System.out.println(ex.getMessage());
        }

        // Should throw TemperatureTooHigh
        try {
            t.setTemp(150);
            System.out.println("Temp set to " + t.getTemperature());
        }
        catch (TempOutOfRangeException ex) {
            System.out.println(ex.getMessage());
        }

        // Should throw TemperatureToolLow
        try {
            t.setTemp(-50);
            System.out.println("Temp set to " + t.getTemperature());
        }
        catch (TempOutOfRangeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
