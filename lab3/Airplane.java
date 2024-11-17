package lab3;

public class Airplane {
    // Поля класу Airplane
    private String model;
    private int capacity;
    private double maxSpeed;
    private double range;
    private int yearOfManufacture;

    // Конструктор класу Airplane
    public Airplane(String model, int capacity, double maxSpeed, double range, int yearOfManufacture) {
        this.model = model;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.range = range;
        this.yearOfManufacture = yearOfManufacture;
    }

    // Гетери
    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getRange() {
        return range;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

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

    @Override
    public String toString() {
        return String.format("Model: %s, Capacity: %d, Max Speed: %.1f km/h, Range: %.1f km, Year: %d",
                model, capacity, maxSpeed, range, yearOfManufacture);
    }
}
