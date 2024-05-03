package AdvJava.Exams.Exam2;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        stackReverse(stack);
        stack.display();
    }
    public static void stackReverse(Stack stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            stackReverse(stack);
            insertAtBottom(stack,temp);
        }
    }

    private static void insertAtBottom(Stack stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, x);
            stack.push(temp);
        }
    }
}

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack is Full!");
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return arr[top--];
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity-1;
    }
    public void peek() {
        System.out.println(arr[top]);
    }
    public int size() {
        return top + 1;
    }
    public void display() {
        for (int i = 0; i < top+1; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }




}
