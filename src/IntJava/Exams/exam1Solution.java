package IntJava.Exams;

public class exam1Solution {
    public static void main(String[] args) {
        int[] arr = {7, 3, 15, 2, 10, 6, 9};
        examSort(arr);
        for (int item : arr)
            System.out.print(item + " ");
    }
    public static void examSort(int[] arr) {
        if (arr.length <= 1)
            return;
        //split
        int pivot = arr[0];
        int smallerCount = 0;
        int largerCount = 0;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] >= pivot)
                largerCount++;
            else
                smallerCount++;
        }
        int[] smallerArr = new int[smallerCount];
        int[] largerArr = new int[largerCount];
        int k = 0;
        int j = 0;
        for (int i = 1 ; i < arr.length ; i++) {
            if(arr[i] >= pivot) {
                largerArr[j++] = arr[i];
            }
            else {
                smallerArr[k++] = arr[i];
            }
        }

        //recursion
        examSort(smallerArr);
        examSort(largerArr);
        //glue
        for(int i = 0; i < smallerArr.length; i++)
            arr[i] = smallerArr[i];
        arr[smallerCount] = pivot;
        for(int i = 0; i < largerArr.length; i++)
            arr[smallerCount+i+1] = largerArr[i];
}
}
