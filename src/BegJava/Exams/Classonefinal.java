package BegJava.Exams;

import java.util.Scanner;

public class Classonefinal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1- Calculate average\n2- Calculate minimum\n3- Calculate maximum\n4- Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            if (choice == 1) {
                System.out.println("Enter the number of integers: ");
                int num = input.nextInt();
                calcAverage(num);
            } else if (choice == 2) {
                System.out.println("The minimum number is: " + calcMinimum());
            } else if (choice == 3) {
                calcMaximum();
            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void calcAverage(int num) {
        Scanner input = new Scanner(System.in);
        if (num <= 0) {
            System.out.println("Invalid number");
            return;
        }
        int sum = 0;
        for (int i = 0; i < num; i++) {
            System.out.println("Enter an integer: ");
            sum += input.nextInt();
        }
        System.out.println("The average is " + (double) sum / num);
    }
    public static int calcMinimum() {
        Scanner input = new Scanner(System.in);
        int min = 0;
        int num = 0;
        boolean first = true;
        while (first) {
            System.out.println("Enter an integer: ");
            num = input.nextInt();
            if (num == -99) {
                System.out.println("No valid number entered, try again.");
                continue;
            }
            min = num;
            first = false;
        }
        while (num != -99) {
            System.out.println("Enter an integer: ");
            num = input.nextInt();
            if (num != -99 && num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void calcMaximum() {
        Scanner input = new Scanner(System.in);
        int max = 0;
        int num = 0;
        boolean first = true;
        while (first) {
            System.out.println("Enter an integer: ");
            num = input.nextInt();
            if (num == -99) {
                System.out.println("No valid number entered, try again.");
                continue;
            }
            max = num;
            first = false;
        }
        while (num != -99) {
            System.out.println("Enter an integer: ");
            num = input.nextInt();
            if (num != -99 && num > max) {
                max = num;
            }
        }
        System.out.println("The maximum number is " + max);
    }
}

//rewriting it much cleaner
/*
public class ProgFund.AdvJava.AdvJava.Exams.Classonefinal {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please enter a choice between 1-4");
            choice = obj.nextInt();
            displayMenu();
        }while(choice > 4 || choice < 1);
        do {
            switch (choice) {
                case 1:
                    System.out.println("Enter how many numbers: ");
                    int num = obj.nextInt();
                    calcAverage(num);
                    break;
                case 2:
                    System.out.println("The minimum number is: " + calcMinimum());
                    break;
                case 3:
                    calcMaximum();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
    }while(choice != 4);
    public static void displayMenu() {
        System.out.println("1- Calc Average");
        System.out.println("2- Calc Minimum");
        System.out.println("3- Calc Maximum");
        System.out.println("4- Exit");
    }
    public static void calcAverage(int num) {
        Scanner obj = new Scanner(System.in);

        while(num <= 0) {
            System.out.println("Negative numbers are not allowed");
            System.out.print("Enter how many numbers: ");
            num = obj.nextInt();
        }
        System.out.println("Hello from average");
        double avg;
        int n;
        double total = 0;
        for(int i = 0; i< num; i++) {
            System.out.print("enter a number: ");
            n = obj.nextInt();
            total = total + n;
        }
        avg = total / num;
        System.out.println("The average is: " + avg);
    }
    public static int calcMinimum() {
        int num;
        int mn;
        Scanner obj = new Scanner(System.in);

        do {
            System.out.print("Enter a number. Cant be 99");
            num = obj.nextInt();
        }while (num == -99);

        mn = num;
        do{
            System.out.print("enter a number. -99 to stop");
            num=obj.nextInt();
            if (num == -99)
                break;
            if (mn > num)
                mn = num;
        }while (num != -99);
    public static void calcMaximum() {
        System.out.println("hello from maximum");
    }
}
*/