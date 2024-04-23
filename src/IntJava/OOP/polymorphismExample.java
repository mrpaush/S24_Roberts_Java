package IntJava.OOP;

import java.util.Scanner;

public class polymorphismExample {
    public static void main(String[] args) {
        Animal a;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a choice ");
        int choice = obj.nextInt();
        if (choice == 1)
            a = new Dog();
        else
            a = new Pig();
        a.animalSound();
        if (a instanceof Dog)
            System.out.println("OOPJava.OOP.Dog");
        else
            System.out.println("OOPJava.OOP.Pig");

    }
}
class Animal {
    public void animalSound() {
        System.out.println("the animal makes a sound");
    }
}
class Pig extends Animal {
    public void animalSound() {
        System.out.println("the pig says: wee wee");
    }
}
class Dog extends Animal {
    public void animalSound() {
        System.out.println("the dog says: bow bow");
    }
}
//polymorphism example



