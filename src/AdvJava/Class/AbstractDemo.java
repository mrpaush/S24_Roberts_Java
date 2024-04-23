package AdvJava.Class;

abstract class ABC {
    public ABC() {
        System.out.println("ABC constructor");
    }

    abstract public void display();
    final public void func1() {
        System.out.println("ABC Func1");
    }
    public static void func2() {
        System.out.println("ABC func2");
    }
}

class XYZ extends ABC {
    public XYZ() {
        System.out.println("XYZ cosntructor");
    }

    public void display() {
        System.out.println("XYZ display");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        ABC obj = new XYZ();
        obj.display();
        ABC.func2();
    }
}
