package BegJava.SortingAlgos;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        //write a code that will have an array of integer. you can hard code that one
        //accept an integer from the user
        //your code should come back with either: found (and the index) or not found
        //make a list of a million number to the array
        int[] arr = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        int num = input.nextInt();
        binarySearch(num, arr);
    }
    public static void binarySearch(int x, int[] y) {
        int mid;
        int low = 0;
        int high = y.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (y[mid] == x) {
                System.out.println("The number " + x + " was found at index " + mid);
                return;
            } else if (y[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("The number " + x + " was not found.");
    }
}
