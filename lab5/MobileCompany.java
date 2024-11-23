package lab5;

import java.util.List;

/**
 * Main class for managing mobile company tariffs.
 */
public class MobileCompany {
    public static void main(String[] args) {
        try {
            // Create a tariff manager
            TarifManager tarifManager = new TarifManager();

            // Add tariffs
            tarifManager.addTarif(new BasicTarif("Basic Plan", 10.0, 150));
            tarifManager.addTarif(new PremiumTarif("Premium Plan", 20.0, 75, 5.0));
            tarifManager.addTarif(new FamilyTarif("Family Plan", 15.0, 50, 4));

            // Print all tariffs
            System.out.println("All tariffs:");
            tarifManager.printTarifs();

            // Calculate the total number of customers
            int totalCustomers = tarifManager.getTotalCustomers();
            System.out.println("\nTotal customers: " + totalCustomers);

            // Sort tariffs by monthly fee
            tarifManager.sortTarifsByMonthlyFee();
            System.out.println("\nTariffs sorted by monthly fee:");
            tarifManager.printTarifs();

            // Find tariffs within a price range
            double minFee = 10.0;
            double maxFee = 20.0;
            System.out.println("\nTariffs in the price range [" + minFee + ", " + maxFee + "]:");
            List<Tarif> tarifsInRange = tarifManager.findTarifsInRange(minFee, maxFee);
            tarifsInRange.forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
