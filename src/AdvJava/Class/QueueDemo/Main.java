package AdvJava.Class.QueueDemo;

public class Main {
    Queue test = new Queue(5);
}

class Queue {
    protected boolean isEmpty;
    protected boolean isFull;
    protected int[] arr;
    protected int front;
    protected int rear;
    protected int size;
    protected int capacity;

    public Queue(int s) {
        size = 0;
        arr = new int[s];
        capacity = s;
        front = 0;
        rear = 0;
    }

    public void enqueue(int e) {
        if (isFull) {
            System.out.println("full");
            return;
        }
            arr[rear] = e;
            size++;
            rear = (rear +1) % capacity;
    }
    public int dequeue() {
        if (isEmpty) {
            System.out.println("empty");
            return -1;
        }
        int item = arr[front];
        front = (front +1) % capacity;
        size--;
        return item;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public void Display() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[(front+i)%capacity]);
        }
    }
    public int peekFront() {
        return arr[front];
    }
    public int peekRear() {
        return arr[rear -1];
    }
}