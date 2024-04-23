package IntJava.OOP.XYZCompany;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

// Company XYZ wants to write a program to do some manipulation for their employees
// They have three types of employees: Full time, part time, hourly ;
// All employees should have an ID and age
// Full time employee has annual salary
// part time employees has special hourly rate and hours allowed
// hourly employees has hourly rate

// your code should be able to allow the XYZ company to:
// add any employee of any type
// List all employees by type
// list all hourly employees above certain hourly rate
// list all full time employees between an age range

public class Main {
    private static final String FILE_PATH = "employees.txt";
    private static List<Emp> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        boolean runFlag = true;
        while (runFlag) {
            System.out.println("1. Add Employee");
            System.out.println("2. List all employees by type");
            System.out.println("3. List all hourly employees above certain hourly rate");
            System.out.println("4. List all full time employees between an age range");
            System.out.println("5. Write employees to file");
            System.out.println("6. Read employees from file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> listEmployeesByType();
                case 3 -> listHourlyEmployeesAboveRate();
                case 4 -> listFullTimeEmployeesBetweenAge();
                case 5 -> writeEmployeesToFile();
                case 6 -> readEmployeesFromFile();
                case 7 -> runFlag = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private static void addEmployee() {
        System.out.println("Enter employee type:");
        System.out.println("1. Full Time");
        System.out.println("2. Part Time");
        System.out.println("3. Hourly");
        System.out.print("Enter your choice: ");
        int type = scanner.nextInt();
        System.out.println();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        System.out.println();

        switch (type) {
            case 1 -> {
                System.out.print("Enter annual salary: ");
                double annualSalary = scanner.nextDouble();
                employees.add(new FullTime(age, annualSalary));
            }
            case 2 -> {
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                System.out.print("Enter hours allowed: ");
                int hoursAllowed = scanner.nextInt();
                employees.add(new PartTime(age, hourlyRate, hoursAllowed));
            }
            case 3 -> {
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                employees.add(new Hourly(age, hourlyRate));
            }
            default -> System.out.println("Invalid employee type. Employee not added.");
        }
    }

    private static void listEmployeesByType() {
        employees.stream()
                .filter(FullTime.class::isInstance)
                .forEach(System.out::println);

        employees.stream()
                .filter(PartTime.class::isInstance)
                .forEach(System.out::println);

        employees.stream()
                .filter(Hourly.class::isInstance)
                .forEach(System.out::println);
    }

    private static void listHourlyEmployeesAboveRate() {
        System.out.print("Enter an hourly rate to find all employees above it: ");
        double hourlyRate = scanner.nextDouble();
        System.out.println();

        employees.stream()
                .filter(Hourly.class::isInstance)
                .map(Hourly.class::cast)
                .filter(employee -> employee.getHourlyRate() > hourlyRate)
                .forEach(System.out::println);
    }

    private static void listFullTimeEmployeesBetweenAge() {
        System.out.print("Enter an age range to find all full-time employees between it (e.g., 21-50): ");
        String range = scanner.next();
        System.out.println();

        int minAge = Integer.parseInt(range.split("-")[0]);
        int maxAge = Integer.parseInt(range.split("-")[1]);

        employees.stream()
                .filter(FullTime.class::isInstance)
                .filter(employee -> employee.getAge() >= minAge && employee.getAge() <= maxAge)
                .forEach(System.out::println);
    }

    private static void writeEmployeesToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Emp employee : employees) {
                writer.println(employee.toString());
            }
            System.out.println("Employees written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing employees to file: " + e.getMessage());
        }
    }

    private static void readEmployeesFromFile() {
        employees.clear();
        try (Scanner fileScanner = new Scanner(new File(FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                String employeeData = fileScanner.nextLine();
                String[] parts = employeeData.split(",");
                String type = parts[0].trim();
                int id = Integer.parseInt(parts[1].trim());
                int age = Integer.parseInt(parts[2].trim());
                switch (type) {
                    case "FullTime" -> {
                        double annualSalary = Double.parseDouble(parts[3].trim());
                        FullTime fullTimeEmployee = new FullTime(age, annualSalary);
                        fullTimeEmployee.setId(id);
                        employees.add(fullTimeEmployee);
                    }
                    case "PartTime" -> {
                        double hourlyRate = Double.parseDouble(parts[3].trim());
                        int hoursAllowed = Integer.parseInt(parts[4].trim());
                        PartTime partTimeEmployee = new PartTime(age, hourlyRate, hoursAllowed);
                        partTimeEmployee.setId(id);
                        employees.add(partTimeEmployee);
                    }
                    case "Hourly" -> {
                        double hourlyRate = Double.parseDouble(parts[3].trim());
                        Hourly hourlyEmployee = new Hourly(age, hourlyRate);
                        hourlyEmployee.setId(id);
                        employees.add(hourlyEmployee);
                    }
                }
            }
            System.out.println("Employees read from file successfully.");
            listEmployeesByType();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}