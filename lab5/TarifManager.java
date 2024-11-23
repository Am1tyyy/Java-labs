package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages a collection of tariffs and provides operations on them.
 */
public class TarifManager {
    private List<Tarif> tarifs;

    /**
     * Constructs an empty TarifManager.
     */
    public TarifManager() {
        tarifs = new ArrayList<>();
    }

    /**
     * Adds a tariff to the manager.
     *
     * @param tarif the tariff to add
     * @throws IllegalArgumentException if the tariff is null
     */
    public void addTarif(Tarif tarif) {
        if (tarif == null) {
            throw new IllegalArgumentException("Tariff cannot be null.");
        }
        tarifs.add(tarif);
    }

    /**
     * Calculates the total number of customers across all tariffs.
     *
     * @return the total number of customers
     */
    public int getTotalCustomers() {
        return tarifs.stream().mapToInt(Tarif::getCustomers).sum();
    }

    /**
     * Sorts tariffs by their monthly fee in ascending order.
     */
    public void sortTarifsByMonthlyFee() {
        tarifs.sort(Comparator.comparingDouble(Tarif::getMonthlyFee));
    }

    /**
     * Finds tariffs with a monthly fee within a specified range.
     *
     * @param minFee the minimum monthly fee
     * @param maxFee the maximum monthly fee
     * @return a list of tariffs within the specified range
     * @throws IllegalArgumentException if the minimum fee is greater than the maximum fee
     */
    public List<Tarif> findTarifsInRange(double minFee, double maxFee) {
        if (minFee > maxFee) {
            throw new IllegalArgumentException("Minimum fee cannot be greater than maximum fee.");
        }
        return tarifs.stream()
                .filter(t -> t.getMonthlyFee() >= minFee && t.getMonthlyFee() <= maxFee)
                .collect(Collectors.toList());
    }

    /**
     * Prints all tariffs to the console.
     */
    public void printTarifs() {
        if (tarifs.isEmpty()) {
            System.out.println("No tariffs available.");
        } else {
            tarifs.forEach(System.out::println);
        }
    }
}
