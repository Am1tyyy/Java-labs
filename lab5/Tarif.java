package lab5;

/**
 * Abstract base class for tariffs.
 */
public abstract class Tarif {
    private String name;
    private double monthlyFee;
    private int customers;

    /**
     * Constructs a Tariff instance with the specified parameters.
     *
     * @param name       the name of the tariff
     * @param monthlyFee the monthly fee for the tariff
     * @param customers  the number of customers for the tariff
     * @throws IllegalArgumentException if the name is null or empty, or if the monthly fee or number of customers is negative
     */
    public Tarif(String name, double monthlyFee, int customers) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Tariff name cannot be null or empty.");
        }
        if (monthlyFee < 0) {
            throw new IllegalArgumentException("Monthly fee cannot be negative.");
        }
        if (customers < 0) {
            throw new IllegalArgumentException("Number of customers cannot be negative.");
        }
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return String.format("Tariff: %s, Monthly Fee: %.2f, Customers: %d", name, monthlyFee, customers);
    }
}
