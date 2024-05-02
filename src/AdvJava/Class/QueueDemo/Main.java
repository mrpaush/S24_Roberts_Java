package AdvJava.Class.QueueDemo;

public class Main {
    Queue test = new Queue(5);
    test.enqueue(5);
}

class Queue {
    protected boolean isEmpty;
    protected boolean isFull;
    protected int[] arr;
    protected int head;
    protected int tail;
    protected final int size;

    public Queue(int s) {
        arr = new int[s];
        size = s;
        head = 0;
        tail = 0;
    }

    public void enqueue(int e) {
        if (isFull) {
            System.out.println("full");
            return;
        }
            arr[tail] = e;
            tail = (tail+1) % size;
    }
    public void dequeue() {
        if (isEmpty) {
            System.out.println("empty");
            return;
        }
        head = (head+1) % size;
    }
    public boolean isEmpty() {
        return head == tail;
    }
    public boolean isFull() {
        return tail == head-1;
    }
    public void Display() {
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println("\n");
    }
    public int peekFront() {
        return arr[head];
    }
    public int peekRear() {
        return arr[tail-1];
    }
}