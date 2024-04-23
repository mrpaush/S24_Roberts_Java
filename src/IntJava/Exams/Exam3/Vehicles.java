package IntJava.Exams.Exam3;

public class Vehicles {
    protected String make;
    protected String vin;
    protected double price;
    public Vehicles(String make, String vin, double price) {
        this.make = make;
        this.vin = vin;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public String getVin() {
        return vin;
    }
    @Override
    public String toString() {
        return make + ", " + vin + ", " + price;
    }
}

class Motorcycles extends Vehicles {
    private int topSpeed;
    public Motorcycles(String make, String vin, double price, int topSpeed) {
        super(make, vin, price);
        this.topSpeed = topSpeed;
    }
    @Override
    public String toString() {
        return "Motorcycles, " + super.toString() + ", " + topSpeed;
    }
}

class Trucks extends Vehicles {
    private int towingCapacity;
    public Trucks(String make, String vin, double price, int towingCapacity) {
        super(make, vin, price);
        this.towingCapacity = towingCapacity;
    }
    @Override
    public String toString() {
        return "Trucks, " + super.toString() + ", " + towingCapacity;
    }
}

class SUVs extends Vehicles {
    private int seats;
    public SUVs(String make, String vin, double price, int seats) {
        super(make, vin, price);
        this.seats = seats;
    }
    @Override
    public String toString() {
        return "SUVs, " + super.toString() + ", " + seats;
    }
}

class ElectricCars extends Vehicles {
    private int range;
    public ElectricCars(String make, String vin, double price, int range) {
        super(make, vin, price);
        this.range = range;
    }
    public int getRange() {
        return range;
    }
    @Override
    public String toString() {
        return "ElectricCars, " + super.toString() + ", " + range;
    }
}

class GasCars extends Vehicles {
    private int horsepower;
    public GasCars(String make, String vin, double price, int horsepower) {
        super(make, vin, price);
        this.horsepower = horsepower;
    }
    @Override
    public String toString() {
        return "GasCars, " + super.toString() + ", " + horsepower;
    }
}

class HybridCars extends Vehicles {
    private int mpg;
    public HybridCars(String make, String vin, double price, int mpg) {
        super(make, vin, price);
        this.mpg = mpg;
    }
    @Override
    public String toString() {
        return "HybridCars, " + super.toString() + ", " + mpg;
    }
}