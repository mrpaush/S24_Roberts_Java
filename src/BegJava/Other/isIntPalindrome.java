package BegJava.Other;

public class isIntPalindrome {
    public static void main(String[] args) {
        int pal1 = 123321;
        int pal2 = 158512;
        System.out.println(isPalindrome(pal1));
        System.out.println(isPalindrome(pal2));
    }
    //palindrome checker without using recursion
    public static boolean isPalindrome(int p) {
        int rev_x = 0;
        int orig_x = p;
        while (p > 0) {
            rev_x = rev_x * 10 + p % 10;
            p = p/10;
        }
        return orig_x == rev_x;
    }
}
