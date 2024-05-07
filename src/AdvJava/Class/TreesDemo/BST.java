package AdvJava.Class.TreesDemo;

public class BST {
    Node root;

    public static void main(String[] args) {
        BST bt = new BST();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(10);
        traversal(bt.root);
        System.out.println(search(bt.root, 3));
        System.out.println(search(bt.root, 10));
        System.out.println("\n");
        delete(bt.root, 3);
        traversal(bt.root);
        System.out.println("\n");
        delete(bt.root, 9);
        traversal(bt.root);
    }

    public void add(int value) {
        root = insert(root, value);
    }

    private Node insert(Node current, int value) {
        if (current == null) return new Node(value);
        if (value < current.value) current.left = insert(current.left, value);
        else if (value > current.value) current.right = insert(current.right, value);
        return current;
    }

    private static void traversal(Node node) { //in order
        if (node == null) {
            return;
        }
        traversal(node.left);
        System.out.println(node.value);
        traversal(node.right);
    }

    private static boolean search(Node current, int value) {
        if (current == null) return false;
        if (current.value == value) return true;
        return value < current.value ? search(current.left, value) : search(current.right, value);
    }

    private static Node delete(Node current, int value) {
        if (current == null) return null;
        if (current.value == value) {
            if (current.left == null && current.right == null) return null;
            if (current.right == null) return current.left;
            if (current.left == null) return current.right;
        }
        if (value < current.value) {
            current.left = delete(current.left, value);
            return current;
        }
        current.right = delete(current.right, value);
        return current;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}