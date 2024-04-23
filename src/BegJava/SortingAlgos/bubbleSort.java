package BegJava.SortingAlgos;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 10, 4};
        sortArray(arr);
    }
    public static void sortArray(int[] a) {
        int temp;
        for (int i = 0; i < a.length-1; i++) {
            boolean swap = false;
            for (int n = 0; n < a.length - i - 1; n++) {
                if (a[n] > a[n + 1]) {
                    temp = a[n];
                    a[n] = a[n + 1];
                    a[n + 1] = temp;
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
