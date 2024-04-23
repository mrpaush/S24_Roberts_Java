package IntJava.Exams.Exam3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dealership.displayMenu();
    }
}

class Dealership {
    private static final String FILE_PATH = "./src/IntJava/Exams/Exam3/vehicles.txt";
    private static List<Vehicles> vehicles = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        int choice;
        do {
            System.out.printf("%-60s%-60s%n", "1. Add a new vehicle to the inventory", "| 6. Display electric cars based on certain range (above certain range)");
            System.out.printf("%-60s%-60s%n", "2. Remove a vehicle based on its VIN number", "| 7. Export the inventory into a text-based file");
            System.out.printf("%-60s%-60s%n", "3. Display details of vehicle based on VIN number", "| 8. Import the inventory from the text-based file");
            System.out.printf("%-60s%-60s%n", "4. Display the vehicles based on lowest price", "| 9. Exit");
            System.out.printf("%-60s%-60s%n", "5. Display vehicles with a price lower than certain amount", "|");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addVehicle();
                case 2 -> removeVehicle();
                case 3 -> displayVehicle();
                case 4 -> displayVehiclesByPriceAscending();
                case 5 -> displayVehiclesOfLowerPriceThanInput();
                case 6 -> displayElectricCarsAboveRange();
                case 7 -> exportInventory();
                case 8 -> importInventory();
                case 9 -> System.out.println("Goodbye!");
                default -> System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
        while (choice != 9);
    }

    private static void addVehicle() {
        int choice;
        do {
            System.out.println("Enter vehicle type:");
            System.out.println("1. Motorcycle");
            System.out.println("2. Trucks");
            System.out.println("3. SUVs");
            System.out.println("4. Electric Cars");
            System.out.println("5. Gas Cars");
            System.out.println("6. Hybrid Cars");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
        }
        while (choice < 1 || choice > 6);
        System.out.print("Enter vehicle make: ");
        String make = scanner.next();
        System.out.print("Enter VIN number: ");
        String vin = scanner.next();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter top speed: ");
                int topSpeed = scanner.nextInt();
                vehicles.add(new Motorcycles(make, vin, price, topSpeed));
            }
            case 2 -> {
                System.out.print("Enter towing capacity: ");
                int towingCapacity = scanner.nextInt();
                vehicles.add(new Trucks(make, vin, price, towingCapacity));

            }
            case 3 -> {
                System.out.print("Enter number of seats: ");
                int seats = scanner.nextInt();
                vehicles.add(new SUVs(make, vin, price, seats));

            }
            case 4 -> {
                System.out.print("Enter range: ");
                int range = scanner.nextInt();
                vehicles.add(new ElectricCars(make, vin, price, range));
            }
            case 5 -> {
                System.out.print("Enter horsepower: ");
                int horsepower = scanner.nextInt();
                vehicles.add(new GasCars(make, vin, price, horsepower));
            }
            case 6 -> {
                System.out.print("Enter mpg: ");
                int mpg = scanner.nextInt();
                vehicles.add(new HybridCars(make, vin, price, mpg));
            }
        }
    }

    private static void removeVehicle() {
        System.out.print("Enter VIN number: ");
        String vin = scanner.next();
        vehicles.removeIf(vehicle -> vehicle.getVin().equals(vin));
    }

    private static void displayVehicle() {
        System.out.print("Enter VIN number: ");
        String vin = scanner.next();
        vehicles.stream()
                .filter(vehicle -> vehicle.getVin().equals(vin))
                .forEach(System.out::println);
    }

    private static void displayVehiclesByPriceAscending() {
        vehicles.stream()
                .sorted(Comparator.comparingDouble(Vehicles::getPrice))
                .forEach(System.out::println);
    }

    private static void displayVehiclesOfLowerPriceThanInput() {
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        vehicles.stream()
                .filter(vehicle -> vehicle.getPrice() < price)
                .forEach(System.out::println);
    }

    private static void displayElectricCarsAboveRange() {
        System.out.print("Enter range: ");
        int range = scanner.nextInt();
        vehicles.stream().
                filter(vehicle -> vehicle instanceof ElectricCars)
                .map(vehicle -> (ElectricCars) vehicle)
                .filter(vehicle -> vehicle.getRange() > range)
                .forEach(System.out::println);
    }

    private static void exportInventory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            vehicles.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void importInventory() {
        vehicles.clear();
        try (Scanner fileScanner = new Scanner(new File(FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                String vehicleData = fileScanner.nextLine();
                String[] parts = vehicleData.split(", ");
                String type = parts[0];
                String make = parts[1];
                String vin = parts[2];
                double price = Double.parseDouble(parts[3]);
                int extra = Integer.parseInt(parts[4]);
                switch (parts[0]) {
                    case "Motorcycles" -> vehicles.add(new Motorcycles(make, vin, price, extra));
                    case "Trucks" -> vehicles.add(new Trucks(make, vin, price, extra));
                    case "SUVs" -> vehicles.add(new SUVs(make, vin, price, extra));
                    case "ElectricCars" -> vehicles.add(new ElectricCars(make, vin, price, extra));
                    case "GasCars" -> vehicles.add(new GasCars(make, vin, price, extra));
                    case "HybridCars" -> vehicles.add(new HybridCars(make, vin, price, extra));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}