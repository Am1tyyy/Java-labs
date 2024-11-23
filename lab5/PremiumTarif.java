package lab5;

/**
 * Represents a premium tariff with an additional service fee.
 */
public class PremiumTarif extends Tarif {
    private double additionalServiceFee;

    /**
     * Constructs a PremiumTarif with the specified parameters.
     *
     * @param name                the name of the tariff
     * @param monthlyFee          the monthly fee for the tariff
     * @param customers           the number of customers for the tariff
     * @param additionalServiceFee the additional service fee
     * @throws IllegalArgumentException if the additional service fee is negative
     */
    public PremiumTarif(String name, double monthlyFee, int customers, double additionalServiceFee) {
        super(name, monthlyFee, customers);
        if (additionalServiceFee < 0) {
            throw new IllegalArgumentException("Additional service fee cannot be negative.");
        }
        this.additionalServiceFee = additionalServiceFee;
    }

    /**
     * Calculates the total fee, including the monthly fee and the additional service fee.
     *
     * @return the total fee
     */
    public double getTotalFee() {
        return getMonthlyFee() + additionalServiceFee;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Additional Service Fee: %.2f", additionalServiceFee);
    }
}
