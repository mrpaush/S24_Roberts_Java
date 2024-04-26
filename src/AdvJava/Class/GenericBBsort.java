package AdvJava.Class;

public class GenericBBsort {
    public static void main(String[] args) {
        Integer[] intArr = {1, 5, 2, 10, 3, 7};
        Double[] doubleArr = {1.0, 5.0, 10.0, 2.0, 7.0};
        Character[] charArr = {'a', 'z', 't', 'b'};
        bbSort(charArr);
        printArray(charArr);
    }

    public static <T> void printArray(T[] arr) {
        for (T elem : arr) {
            System.out.println(elem);
        }
    }

    public static <T extends Comparable<T>> void bbSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
