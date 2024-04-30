package AdvJava.Class.LinkedListDemo;
import java.util.LinkedList;
import java.util.Scanner;

public class linkedListDemo {
    public static void main(String[] args) {
        LinkedList<Product> prodLL = new LinkedList<>();
        Scanner obj = new Scanner(System.in);
        System.out.println("Please enter number of objects");
        int num = obj.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Please enter ID");
            int num2 = obj.nextInt();
            System.out.println("Please enter Price");
            Double num3 = obj.nextDouble();
            System.out.println("Please enter Manufacturer");
            String num4= obj.next();
            Product newProd = new Product(num2, num3, num4);
            putInPlace(prodLL, newProd);
            System.out.println(prodLL);
        }

    }
    public static void putInPlace(LinkedList<Product> link, Product newProd) {
        if (link.isEmpty()) {
            link.add(newProd);
            return;
        }
        for (int i = 0; i < link.size(); i++) {
            if (newProd.getPrice().compareTo(link.get(i).getPrice()) < 0) {
                link.add(i, newProd);
                return;
            }
        }
        link.add(newProd);
    }
}
