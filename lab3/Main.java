package lab3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Demonstrates the usage of the Airplane class, including sorting and searching operations.
 */
public class Main {
    public static void main(String[] args) {
        // Create an array of airplanes
        Airplane[] airplanes = {
            new Airplane("Boeing 737", 180, 850, 6000, 2010),
            new Airplane("Airbus A320", 150, 830, 6100, 2015),
            new Airplane("Boeing 777", 396, 905, 15600, 2005),
            new Airplane("Airbus A380", 555, 900, 15700, 2008),
            new Airplane("Concorde", 92, 2179, 7250, 1976)
        };

        // Sort airplanes by year of manufacture (ascending) and by range (descending)
        Arrays.sort(airplanes, Comparator.comparingInt(Airplane::getYearOfManufacture)
                                         .thenComparing(Comparator.comparingDouble(Airplane::getRange).reversed()));

        // Display the sorted array of airplanes
        System.out.println("Sorted Airplanes:");
        for (Airplane airplane : airplanes) {
            System.out.println("  " + airplane);
        }

        // Define a target airplane for searching
        Airplane targetAirplane = new Airplane("Boeing 737", 180, 850, 6000, 2010);

        // Search for an object identical to the target airplane
        boolean found = false;
        for (Airplane airplane : airplanes) {
            if (airplane.equals(targetAirplane)) {
                System.out.println("\nFound matching airplane:");
                System.out.println("  " + airplane);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nNo matching airplane found.");
        }
    }
}
