package de.bcxp.challenge;
import com.opencsv.CSVReader;

import java.io.*;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        Weather weatherData;
        Countries countries;

        try {
            weatherData = new Weather(new CSVReader(new FileReader(App.class.getResource("weather.csv").getPath())));
            countries = new Countries(new CSVReader(new FileReader(App.class.getResource("countries.csv").getPath())));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %d%n", weatherData.getDayWithSmallestTemperatureSpread());

        // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countries.getCountryWithHighestPopulationDensity());
    }
}
