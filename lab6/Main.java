

import java.util.Arrays;

/**
 * Demonstrates the usage of the CustomSet class.
 */
public class Main {
    public static void main(String[] args) {
        // Example 1: Empty constructor
        CustomSet<Integer> set1 = new CustomSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        System.out.println("Set 1: " + set1);

        // Example 2: Constructor with a single element
        CustomSet<String> set2 = new CustomSet<>("Hello");
        set2.add("World");
        set2.add("Hello"); // Duplicate, won't be added
        System.out.println("Set 2: " + set2);

        // Example 3: Constructor with a collection
        CustomSet<Double> set3 = new CustomSet<>(Arrays.asList(1.1, 2.2, 3.3, 1.1));
        System.out.println("Set 3: " + set3);

        // Demonstrate removal and contains methods
        set3.remove(2.2);
        System.out.println("Set 3 after removal: " + set3);
        System.out.println("Set 3 contains 3.3: " + set3.contains(3.3));
    }
}