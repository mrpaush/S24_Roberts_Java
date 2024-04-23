package BegJava.Arrays;

import java.util.Arrays;

public class merging2SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {5, 6, 7, 8, 9};
        int[] arr2 = {2, 3, 10, 11};
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr3.length) {
            if (j < arr1.length && k < arr2.length) {
                arr3[i++] = arr1[j] < arr2[k] ? arr1[j++] : arr2[k++];
            } else if (j < arr1.length) {
                arr3[i++] = arr1[j++];
            } else {
                arr3[i++] = arr2[k++];
            }
        }
//      while (i < arr3.length) arr3[i++] = j < arr1.length && (k >= arr2.length || arr1[j] < arr2[k]) ? arr1[j++] : arr2[k++];
        Arrays.stream(arr3).forEach(System.out::println);
    }
}
