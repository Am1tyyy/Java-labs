package lab5;

/**
 * Represents a family tariff that includes a specified number of family members.
 */
public class FamilyTarif extends Tarif {
    private int familyMembers;

    /**
     * Constructs a FamilyTarif with the specified parameters.
     *
     * @param name          the name of the tariff
     * @param monthlyFee    the monthly fee for the tariff
     * @param customers     the number of customers for the tariff
     * @param familyMembers the number of family members included in the tariff
     * @throws IllegalArgumentException if the number of family members is less than or equal to zero
     */
    public FamilyTarif(String name, double monthlyFee, int customers, int familyMembers) {
        super(name, monthlyFee, customers);
        if (familyMembers <= 0) {
            throw new IllegalArgumentException("Number of family members must be greater than zero.");
        }
        this.familyMembers = familyMembers;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Family Members: %d", familyMembers);
    }
}
