package BegJava.SortingAlgos;

public class mergeSort {
    //merge sort
    public static void main(String[] args) {
        int[] arr = {10, 5, 9, 12, 4, 6, -1};
        mergeSort(arr, 0, arr.length-1);
        for (int item : arr)
            System.out.print(item + " ");
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int sizeLeft = mid-left+1;
        int sizeRight = right-mid;
        int[] arrLeft = new int[sizeLeft];
        int[] arrRight = new int[sizeRight];
        for (int i = 0; i < sizeLeft; i++) arrLeft[i] = arr[left+i];
        for (int i = 0; i < sizeRight; i++) arrRight[i] = arr[mid+i+1];
        int i = 0, j = 0;
        int k = left;
        while(i < sizeLeft && j < sizeRight) {
            if (arrLeft[i] <= arrRight[j])
                arr[k++] = arrLeft[i++];
            else arr[k++] = arrRight[j++];
        }
        while(i < sizeLeft) arr[k++] = arrLeft[i++];
        while(j < sizeRight) arr[k++] = arrRight[j++];
    }
}
