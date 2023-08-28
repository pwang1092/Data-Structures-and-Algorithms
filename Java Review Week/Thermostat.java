package DataStructuresAndAlgorithms;

import java.util.*;

public class Thermostat {
    private double low;
    private double high;
    private double temperature;

    public Thermostat(double low, double high) {
        this.low = low;
        this.high = high;
    }

    public void setTemp(double temperature) throws TempOutOfRangeException {
        if (temperature < low) {
            throw new TempTooLowException ("Temp cannot be lower than " + low);
        }
        else if (temperature > high) {
            throw new TempTooHighException("Temp cannot be higher than " + high);
        }
        else {
            this.temperature = temperature;
        }
    }

    public double getTemperature() {
        return temperature;
    }
}
