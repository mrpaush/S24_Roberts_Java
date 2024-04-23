package BegJava.Arrays;

public class maxRow {
    public static void main(String[] args) {
        int[][] grades = {{0, 31}, {5, 17}, {8, 9}};
        maxRow(grades);
    }
    public static void display(int[][] e) {
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e[i].length; j++)
                System.out.print(e[i][j] + " ");
            System.out.print("\n");
        }
    }
    //given several rows find the row that has the maximum value when adding the values in that row
    public static void maxRow(int[][] e) {
        int max = 0;
        int row = 0;
        for(int i = 0; i < e[0].length; i++)
            max = max + e[0][i];
        for (int i = 1; i < e.length; i++) {
            int temp = 0;
            for (int j = 0; j < e[i].length; j++) {
                temp += e[i][j];
            }
            if (temp > max) {
                max = temp;
                row = i;
            }
        }
        System.out.println("max: " + max + ", row: " + row);
    }
}
