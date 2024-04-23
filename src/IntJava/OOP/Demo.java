package IntJava.OOP;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //auto 1
        Automobile auto1 = new Automobile();
        System.out.println("Enter make, price, tire price, tire make, tire mileage separated by a comma and a space for the first auto\n" + "Example: Toyota, 20000, 100, Michelin, 10000");
        // example input: "Toyota, 20000, 100, Michelin, 10000"
        String[] auto1Data = input.nextLine().split(", ");
        auto1.setMake(auto1Data[0]);
        auto1.setPrice(Double.parseDouble(auto1Data[1]));
        auto1.getTire().setPrice(Double.parseDouble(auto1Data[2]));
        auto1.getTire().setMake(auto1Data[3]);
        auto1.getTire().setMileage(Integer.parseInt(auto1Data[4]));
        System.out.println(Automobile.autoCount() + " total Automobiles created" + "\n" + auto1.toString());

        //auto 2
        System.out.println("Enter make, price, tire price, tire make, tire mileage separated by a comma and a space for the second auto\n" + "Example: Toyota, 20000, 100, Michelin, 10000");
        String[] auto2Data = input.nextLine().split(", ");
        Tire tire2 = new Tire(Double.parseDouble(auto2Data[2]), auto2Data[3], Integer.parseInt(auto2Data[4]));
        Automobile auto2 = new Automobile(auto2Data[0], Double.parseDouble(auto2Data[1]), tire2);
        System.out.println(Automobile.autoCount() + " total Automobiles created" + "\n" + auto2.toString());

        //auto 3
        System.out.println("Enter make, price, tire price, tire make, tire mileage separated by a comma and a space for the third auto\n" + "Example: Toyota, 20000, 100, Michelin, 10000");
        String[] auto3Data = input.nextLine().split(", ");
        Tire tire3 = new Tire(Double.parseDouble(auto3Data[2]), auto3Data[3], Integer.parseInt(auto2Data[4]));
        Automobile auto3 = new Automobile(auto3Data[0], Double.parseDouble(auto3Data[1]), tire3);
        System.out.println(Automobile.autoCount() + " total Automobiles created" + "\n" + auto3.toString());

        //Use the toString to display the object with the highest tire price
        System.out.println("The automobile with the highest tire price is:");
        if (auto1.getTire().getPrice() > auto2.getTire().getPrice() && auto1.getTire().getPrice() > auto3.getTire().getPrice()) {
            System.out.println(auto1.toString());
        } else if (auto2.getTire().getPrice() > auto1.getTire().getPrice() && auto2.getTire().getPrice() > auto3.getTire().getPrice()) {
            System.out.println(auto2.toString());
        } else {
            System.out.println(auto3.toString());
        }
        //use the toString to display the object with the lowest automobile price
        System.out.println("The automobile with the lowest car price is:");
        if (auto1.getPrice() < auto2.getPrice() && auto1.getPrice() < auto3.getPrice()) {
            System.out.println(auto1.toString());
        } else if (auto2.getPrice() < auto1.getPrice() && auto2.getPrice() < auto3.getPrice()) {
            System.out.println(auto2.toString());
        } else {
            System.out.println(auto3.toString());
        }
    }
}

/*
FANCIER VERSION

public class OOPJava.OOP.Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        OOPJava.OOP.Automobile[] autos = new OOPJava.OOP.Automobile[3];

        for (int i = 0; i < autos.length; i++) {
            System.out.println("Enter make, price, tire price, tire make, tire mileage separated by a comma and a space for the auto\n" + "Example: Toyota, 20000, 100, Michelin, 10000");
            String[] autoData = input.nextLine().split(", ");
            OOPJava.OOP.Tire tire = new OOPJava.OOP.Tire(Double.parseDouble(autoData[2]), autoData[3], Integer.parseInt(autoData[4]));
            autos[i] = new OOPJava.OOP.Automobile(autoData[0], Double.parseDouble(autoData[1]), tire);
            System.out.println(OOPJava.OOP.Automobile.autoCount() + " total Automobiles created" + "\n" + autos[i].toString() + "\n");
        }

        printAutoWithHighestTirePrice(autos);
        printAutoWithLowestCarPrice(autos);
    }

    public static void printAutoWithHighestTirePrice(OOPJava.OOP.Automobile[] autos) {
        System.out.println("The automobile with the highest tire price is:");
        OOPJava.OOP.Automobile highestTirePriceAuto = ProgFund.Arrays.stream(autos)
                .max((auto1, auto2) -> Double.compare(auto1.getTire().getPrice(), auto2.getTire().getPrice()))
                .orElse(null);
        System.out.println(highestTirePriceAuto);
    }

    public static void printAutoWithLowestCarPrice(OOPJava.OOP.Automobile[] autos) {
        System.out.println("The automobile with the lowest car price is:");
        OOPJava.OOP.Automobile lowestCarPriceAuto = ProgFund.Arrays.stream(autos)
                .min((auto1, auto2) -> Double.compare(auto1.getPrice(), auto2.getPrice()))
                .orElse(null);
        System.out.println(lowestCarPriceAuto);
    }
}
*/

class Tire {
    private double Price;
    private String Make;
    private int Mileage;

    public Tire(double price, String make, int mileage) {
        Price = price;
        Make = make;
        Mileage = mileage;
        //ensure price is not negative and mileage is more than 5000, otherwise set price to 0 and mileage to 5000
        if (price < 0.0) {
            Price = 0.0;
        }
        if (mileage < 5000) {
            Mileage = 5000;
        }
    }

    public Tire() {
        this(0.0, "none", 5000);
    }

    public double getPrice() {return Price;}
    public void setPrice(double price) {Price = price;}
    public String getMake() {return Make;}
    public void setMake(String make) {Make = make;}
    public int getMileage() {return Mileage;}
    public void setMileage(int mileage) {Mileage = mileage;
    }
    public String toString() {
        return "OOPJava.OOP.Tire{" + "Price=" + Price + ", Make='" + Make + '\'' + ", Mileage=" + Mileage + '}';
    }
}

class Automobile {
    //hold number of instantiated objects of this class
    private static int count = 0;
    private String Make;
    private double Price;
    private Tire tire;

    public Automobile() {
        this("none", 0.0, new Tire());
    }

    public Automobile(String make, double price, Tire t) {
        Make = make;
        Price = price;
        tire = t;
        count++;
        if (price < 0.0) {
            Price = 0.0;
        }
    }

    public static int autoCount() {return count;}
    public String getMake() {return Make;}
    public void setMake(String make) {Make = make;}
    public double getPrice() {return Price;}
    public void setPrice(double price) {Price = price;}
    public Tire getTire() {return tire;}
    public void setTire(Tire tire) {this.tire = tire;}

    public String toString() {
        return "OOPJava.OOP.Automobile{" + "Make='" + Make + '\'' + ", Price=" + Price + ", tire=" + tire + '}';
    }
}
