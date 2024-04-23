package BegJava.Arrays;

public class loShuSquare {
    //write a program that will detect the Lo Shu square
    public static void main(String[] args) {
        int[][] square = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}; //valid
        int[][] square2 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 5}}; //invalid
        int[][] square3 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 10}}; //invalid
        int[][] square4 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}; //invalid
        int[][] square5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; //invalid
        int[][] square6 = {{9, 3, 22, 16, 15}, {2, 21, 20, 14, 8}, {25, 19, 13, 7, 1}, {18, 12, 6, 5, 24}, {11, 10, 4, 23, 17}}; //valid
        //a valid one we haven't used yet

        System.out.println(loShu(square));
        System.out.println(loShu(square2));
        System.out.println(loShu(square3));
        System.out.println(loShu(square4));
        System.out.println(loShu(square5));
        System.out.println(loShu(square6));

    }

    public static boolean loShu(int[][] a) {
        //check for uniques
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int p = 0; p < a.length; p++) {
                    for (int q = 0; q < a[p].length; q++) {
                        if ((i != p || j != q) && a[i][j] == a[p][q]) {
                            return false;
                        }
                    }
                }
            }
        }
        //check diagonals
        int sumDiag1 = 0;
        int sumDiag2 = 0;
        for (int i = 0; i < a.length; i++) {
            sumDiag1 += a[i][i];
            sumDiag2 += a[i][a.length - 1 - i];
        }
        //check if the same sum in rows and columns
        int sumRow = 0;
        int sumCol = 0;
        for (int i = 0; i < a.length; i++) {
            int tempRow = 0;
            int tempCol = 0;
            for (int j = 0; j < a[i].length; j++) {
                tempRow += a[i][j];
                tempCol += a[j][i];
            }
            if (i == 0) {
                sumRow = tempRow;
                sumCol = tempCol;

            } else if (tempRow != sumRow || tempCol != sumCol) {
                return false;
            }
        }
        return true;
    }
}