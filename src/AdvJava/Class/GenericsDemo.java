package AdvJava.Class;
//
//class ABC <T,E> {
//    private T a;
//    private E b;
//    public ABC(T value, E value2){
//        a = value;
//        b = value2;
//    }
//    public void setA(T value) {
//        a = value;
//    }
//    public void setB(E value) {
//        b = value;
//    }
//    public void display() {
//        System.out.println(a);
//        System.out.println(b);
//    }
//}
//
//public class GenericsDemo {
//    public static void main(String[] args) {
//        ABC<Integer,String> obj = new ABC<>(10, "Amr");
//        obj.display();
//        obj.setA(30);
//        obj.setB("John");
//        obj.display();
//    }
//}

public class GenericsDemo {
    public static void main(String[] args) {
        Integer a = 30;
        display(a);
        String x = "ABC";
        display(x);

    }

    public static <T> void display(T a) {
        System.out.println(a);
    }
    public static <T> void swap(T a, T b) {
        T temp;
        temp = a;
        a = b;
        b = temp;
    }
}