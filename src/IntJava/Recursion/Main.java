package IntJava.Recursion;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,6,3,4,2,9,8,5,7,-1000,20000};
        int[] arr2 = {1,2,3,5,2};
        int[] arr3 = {1,2,3,4,5};
        System.out.println(checkSorted(arr, 0));
    }
    public static boolean checkSorted(int[] arr, int start) {
        return start == arr.length-1 || arr[start] < arr[start + 1] && checkSorted(arr, start + 1);
    }
}
