package AdvJava.Exams.Exam1;

public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {1, 5, 2, 10, 3, 7};
        Double[] doubleArr = {1.0, 5.0, 10.0, 2.0, 7.0};
        Character[] charArr = {'a', 'z', 't', 'b'};
        Employee emp1 = new Employee("Paul", 28);
        Employee emp2 = new Employee("John", 26);
        Employee emp3 = new Employee("Josh", 30);
        Employee emp4 = new Employee("Amr", 28);
        Employee[] empArr = {emp1, emp2, emp3, emp4};
        mergeSort(intArr, 0, intArr.length-1);
        printArray(intArr);
        mergeSort(doubleArr, 0, doubleArr.length-1);
        printArray(doubleArr);
        mergeSort(charArr, 0, charArr.length-1);
        printArray(charArr);
        mergeSort(empArr, 0, empArr.length-1);
        printArray(empArr);
    }
    public static <T> void printArray(T[] arr) {
        for (T elem: arr) {
            System.out.println(elem);
        }
        System.out.println();
    }
    public static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        int start2 = mid+1;

        if (arr[mid].compareTo(arr[start2]) <= 0) {
            return;
        }
        while (left <= mid && start2 <= right) {
            if (arr[left].compareTo(arr[start2]) <= 0) {
                left++;
            }
            else {
                T value = arr[start2];
                int index = start2;

                while (index != left) {
                    arr[index] = arr[index-1];
                    index--;
                }
                arr[left] = value;

                left++;
                mid++;
                start2++;
            }
        }
    }
}
