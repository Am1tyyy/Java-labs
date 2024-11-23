package lab5;

/**
 * Represents a basic tariff.
 */
public class BasicTarif extends Tarif {
    /**
     * Constructs a BasicTarif with the specified name, monthly fee, and number of customers.
     *
     * @param name      the name of the tariff
     * @param monthlyFee the monthly fee for the tariff
     * @param customers  the number of customers for the tariff
     */
    public BasicTarif(String name, double monthlyFee, int customers) {
        super(name, monthlyFee, customers);
    }
}
