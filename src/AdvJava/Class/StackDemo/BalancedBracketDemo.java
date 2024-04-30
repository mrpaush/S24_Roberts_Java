package AdvJava.Class.StackDemo;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracketDemo {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a string to check");
        String check = obj.nextLine();
//        if (isBalanced(check)) {
//            System.out.println("Balanced");
//        } else {
//            System.out.println("Unbalanced");
//        }
        System.out.println(infixResult(check));
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static int infixResult(String str) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (char c : str.toCharArray()) {
            if (c != '*' && c != '+' && c != '-' && c != '/') {
                stack.push(c - '0');
            }
            else  {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (c == '*') result = num1 * num2;
                else if (c == '+') result = num1 + num2;
                else if (c == '-') result = num1 - num2;
                else result = num1 / num2;
                stack.push(result);
            }
        }
        return result;
    }
}