package BegJava.Recursion;

public class recursionPractice {
    public static void main(String[] args) {
        //make factorial in recursion
        int num = 5;
        System.out.println("Factorial of " + num + " is " + recFactorial(num));
        System.out.println("Recursive add of " + num + " is " + recAdd(num));
        System.out.println("Recursive fibonacci of " + num + " is " + recFibonacci(num));
        System.out.println("iterative fibonacci of " + num + " is " + Fibonacci(num));
        System.out.println("Sum of digits of " + num + " is " + sumOfDigits(1234));
    }
    public static int recFactorial(int num) {
        return num == 1 ? 1 : num * recFactorial(num-1);
    }

    public static int recAdd(int num) {
        return num == 1 ? 1 : num + recAdd(num-1);
    }

    public static int recFibonacci(int num) {
        return num == 0 || num == 1 ? 1 : recFibonacci(num-1) + recFibonacci(num-2);
    }
    public static int Fibonacci(int num) {
        int a = 1, b = 1, ans;
        for (int i = 2; i <= num; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }
        return b;
    }
    public static int sumOfDigits(int num) {
        return num < 10 ? num : sumOfDigits(num%10) + sumOfDigits(num/10);
    }
}
