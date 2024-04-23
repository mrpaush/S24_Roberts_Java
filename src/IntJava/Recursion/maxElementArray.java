package IntJava.Recursion;

public class maxElementArray {
    //write a java recursive method to find the maximum element in an array
    public static void main(String[] args) {
        int[] arr = {1,6,3,4,2,9,8,5,7,-1000,20000};
        int max = findMax(arr, 0, 0);
        System.out.println(max);
        int maxDC = findMaxDC(arr, 0, arr.length-1);
        System.out.println(maxDC);
    }
    public static int findMax(int[] arr, int max, int current) {
        if (current == arr.length) return arr[max];
        return arr[max] >= arr[current] ? findMax(arr, max, current+1) : findMax(arr, current, current+1);
    }
    public static int findMax2(int[] arr, int size) {
        if (size == 1)
            return arr[0];
        return Math.max(arr[size-1], findMax2(arr,size-1));
    }
    public static int findMaxDC(int[] arr, int left, int right) {
        return left >= right ? arr[left] : Math.min(findMaxDC(arr, left, (left+right)/2), findMaxDC(arr, (left+right)/2+1, right));
    }
}
