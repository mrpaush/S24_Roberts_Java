package BegJava.Arrays;//arraylists

public class isUnique {
    //write a program that will test if a single dimensional array has all unique values
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        if (unique(arr2)) {
            System.out.println("The array has all unique values.");
        } else {
            System.out.println("The array does not have all unique values.");
        }
    }
    public static boolean unique(int[] a) {
        int l = a.length;
        for (int i = 0; i < l-1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (a[i] == a[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
