package IntJava.Exams;

public class Exam2Final {
    public static void main(String[] args) {
        String a = "Roberts";
        String b = "Paul";
        swapWithoutTemp(a, b);
        String permTest = "JSP";
        stringPerm(b, 0, permTest.length());
    }

    // Problem 1
    // Write a Java program to swap two string variables without using third or temp variable.
    public static void swapWithoutTemp(String a, String b) {
        System.out.println("Current string is: " + a + " " + b);
        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());
        System.out.println("Current String is: " + a + " " + b);
    }

    //Problem 2
    // Write a Java program to find all permutations of a string recursively. For example, all permutations of string “JSP“ are:
    //JSP, JPS, SJP, SPJ, PJS, PSJ
    public static void stringPerm(String s, int left, int right) {
        //in one function
        if (left == right) {
            System.out.println(s);
        } else {
            for (int i = left; i < right; i++) {
                s = swap(s, left, i);
                stringPerm(s, left + 1, right);
                s = swap(s, left, i);

            }
        }
    }
    public static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
}
