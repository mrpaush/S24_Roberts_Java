//package AdvJava.Class;
//
//interface ABC {
//    int a = 0;
//    //by default public static and final
//    void display();
//
//    void func1();
//
//    void func2(int a);
//
//    default void func3() {
//        System.out.println("ABC default");
//    }
//}
//
//interface XYZ {
//    void func2();
//}
//
//class AAA implements XYZ, ABC {
//    public void func2() {
//        System.out.println("AAA func2");
//    }
//    public void func2(int a) {
//        System.out.println(a);
//    }
//
//    public void func1() {
//        System.out.println("AAA fucn1");
//    }
//
//    public void display() {
//        System.out.println("AAA dipslay");
//    }
//}
//
//public class InterfaceDemo {
//    public static void main(String[] args) {
//        ABC obj = new AAA();
//        obj.func1();
//        System.out.println(obj.a);
//    }
//}
