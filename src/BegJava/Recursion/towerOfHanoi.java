package BegJava.Recursion;

import java.util.Arrays;

public class towerOfHanoi {
    public static void main(String[] args) {
        //write a function (tower of hanoi) to move 3 disks from a to c. You can use b, one disk at a time, only move disks at the top, disks can only
        //sit on disks bigger than them. A -> C, A -> B, C -> B, A -> C, etc.
        towerOfHanoi(5, 'A', 'C', 'B');
    }
    public static void towerOfHanoi(int n, char from, char to, char using) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n-1, from, using, to);
        System.out.println(from + " -> " + to);
        towerOfHanoi(n-1, using, to, from);
    }
    /*
A -> C
A -> b
C -> b
A -> c
B -> a
B -> c
A -> c
*/
    public static int printNums(int[] n) { //copy of array way
        return n.length == 1 ? n[0] : n[0] + printNums(Arrays.copyOfRange(n, 1, n.length));
    }
    public static int printNums2(int[] n, int a) { // way easier to understand
        return a == 0 ? 0 : n[a-1] + printNums2(n, a-1);
    }
}