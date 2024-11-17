package lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Створення масиву літаків
        Airplane[] airplanes = {
            new Airplane("Boeing 737", 180, 850, 6000, 2010),
            new Airplane("Airbus A320", 150, 830, 6100, 2015),
            new Airplane("Boeing 777", 396, 905, 15600, 2005),
            new Airplane("Airbus A380", 555, 900, 15700, 2008),
            new Airplane("Concorde", 92, 2179, 7250, 1976)
        };

        // Сортування масиву літаків за зростанням за роком виробництва і за спаданням за дальністю польоту
        Arrays.sort(airplanes, Comparator.comparingInt(Airplane::getYearOfManufacture)
                                         .thenComparing(Comparator.comparingDouble(Airplane::getRange).reversed()));

        // Вивід відсортованого масиву
        System.out.println("Sorted Airplanes:");
        for (Airplane airplane : airplanes) {
            System.out.println("  " + airplane);
        }

        // Задання літака для пошуку
        Airplane targetAirplane = new Airplane("Boeing 737", 180, 850, 6000, 2010);

        // Пошук об'єкта, ідентичного заданому
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
