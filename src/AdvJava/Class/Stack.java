package AdvJava.Class;

import java.util.Arrays;

public class Stack {
    private int[] arr;
    private int size;
    private int Head = 0;
    private boolean isEmpty;
    private boolean isFull;

    public Stack(int s) {
        this.size = s;
    }
    public boolean isEmpty() {
        return Head == 0;
    }
    public boolean isFull() {
        return Head == size;
    }
    public int peek() {
        return arr[Head];
    }
    public void push(int i) {
        if (!isFull) {
            arr[Head] = i;
            Head++;
        }
    }
    public int pop() {
        if (!isEmpty) {
            System.out.println(arr[Head]);
            Head--;
        }
    }
}
