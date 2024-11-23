package lab3;

/**
 * Represents an airplane with attributes such as model, capacity, maximum speed, range, and year of manufacture.
 */
public class Airplane {
    // Fields of the Airplane class
    private String model;
    private int capacity;
    private double maxSpeed;
    private double range;
    private int yearOfManufacture;

    /**
     * Constructs an Airplane instance with specified attributes.
     *
     * @param model             the model of the airplane
     * @param capacity          the seating capacity of the airplane
     * @param maxSpeed          the maximum speed of the airplane in km/h
     * @param range             the range of the airplane in km
     * @param yearOfManufacture the year the airplane was manufactured
     */
    public Airplane(String model, int capacity, double maxSpeed, double range, int yearOfManufacture) {
        this.model = model;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.range = range;
        this.yearOfManufacture = yearOfManufacture;
    }

    // Getters

    /**
     * Gets the model of the airplane.
     *
     * @return the model of the airplane
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the seating capacity of the airplane.
     *
     * @return the seating capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the maximum speed of the airplane.
     *
     * @return the maximum speed in km/h
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Gets the range of the airplane.
     *
     * @return the range in km
     */
    public double getRange() {
        return range;
    }

    /**
     * Gets the year the airplane was manufactured.
     *
     * @return the year of manufacture
     */
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    /**
     * Compares this airplane with another object for equality based on all attributes.
     *
     * @param obj the object to compare
     * @return {@code true} if the objects are equal; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Airplane airplane = (Airplane) obj;
        return capacity == airplane.capacity &&
               Double.compare(airplane.maxSpeed, maxSpeed) == 0 &&
               Double.compare(airplane.range, range) == 0 &&
               yearOfManufacture == airplane.yearOfManufacture &&
               model.equals(airplane.model);
    }

    /**
     * Returns a string representation of the airplane.
     *
     * @return a formatted string containing the airplane's attributes
     */
    @Override
    public String toString() {
        return String.format("Model: %s, Capacity: %d, Max Speed: %.1f km/h, Range: %.1f km, Year: %d",
                model, capacity, maxSpeed, range, yearOfManufacture);
    }
}
