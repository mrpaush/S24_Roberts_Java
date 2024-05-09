package AdvJava.Exams.Exam3;

public class Main {
    public static void main(String[] args) {
        System.out.println("After Insertions:");
        LinkedList examList = new LinkedList();
        examList.insertNode(1);
        examList.insertNode(2);
        examList.insertNode(4);
        examList.insertNode(3);
        examList.insertNode(5);
        examList.Display();
        System.out.println();

        System.out.println("Searching existing 3 and non existing 6:");
        System.out.println(examList.searchNode(3));
        System.out.println(examList.searchNode(6));
        System.out.println();

        System.out.println("Testing deletion:");
        examList.deleteNode(3);
        examList.Display();
        System.out.println();

        System.out.println("Testing after Clear:");
        examList.Clear();
        examList.Display();
    }
}

class Node {
    public int Key;
    public Node forward;
    public Node backward;

    public Node(int k) {
        this.Key = k;
        this.backward = null;
        this.forward = null;
    }
}

class LinkedList {
    static Node head;
    static Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public static void Display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.Key + " --> ");
            temp = temp.forward;
        }
        System.out.println("NULL");
    }

    public static void Clear() {
        head = null;
        tail = null;
    }

    public static void insertNode(int k) {
        Node newNode = new Node(k);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        if (k < head.Key) {
            newNode.forward = head;
            head.backward = newNode;
            head = newNode;
            return;
        }
        Node current = head;
        while (current.forward != null && current.forward.Key < k) {
            current = current.forward;
        }
        newNode.forward = current.forward;
        if (current.forward != null) {
            current.forward.backward = newNode;
        } else {
            tail = newNode;
        }
        current.forward = newNode;
        newNode.backward = current;
    }

    public static boolean searchNode(int k) {
        Node temp = head;
        while (temp != null) {
            if (k == temp.Key) return true;
            temp = temp.forward;
        }
        return false;
    }

    public static void deleteNode(int k) {
        Node temp = head;
        while (temp != null) {
            if (k == temp.Key) {
                if (temp == head) {
                    head = temp.forward;
                    if (head != null) {
                        head.backward = null;
                    }
                    else {
                        tail = null;
                    }
                }
                else if (temp == tail) {
                    tail = temp.backward;
                    tail.forward = null;
                }
                else {
                    temp.backward.forward = temp.forward;
                    temp.forward.backward = temp.backward;
                }
                return;
            }
            temp = temp.forward;
        }
    }
}