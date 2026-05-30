package com.functional;
import java.util.function.Function;

class SensorData {

    private double temperature;

    public SensorData(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}

public class Example6 {

    public static void main(String[] args) {

        // SensorData Object
        SensorData data = new SensorData(30.5);

        // Local Variable
        double threshold = 25.0;

        // First Functional Interface
        Function<SensorData, Double> getTemperature =
                new Function<SensorData, Double>() {

            @Override
            public Double apply(SensorData data) {
                return data.getTemperature();
            }
        };

        // Extract Temperature
        Double temperature = getTemperature.apply(data);

        System.out.println("Temperature: " + temperature);

        // Second Functional Interface
        Function<Double, Boolean> checkTemperature =
                new Function<Double, Boolean>() {

            @Override
            public Boolean apply(Double temp) {
                return temp > threshold;
            }
        };

        // Check Threshold
        Boolean result = checkTemperature.apply(temperature);

        System.out.println(result);
    }
}