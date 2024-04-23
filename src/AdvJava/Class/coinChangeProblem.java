package AdvJava.Class;

import java.util.Scanner;

public class coinChangeProblem {
    public static void main(String[] args) {
        Scanner object = new Scanner(System.in);
        System.out.println("Input total cents");
        int cents = object.nextInt();
        System.out.println("Input amount of coins");
        int[] coinAmount = new int[object.nextInt()];
        System.out.println("Input coin values");
        for (int i = 0; i < coinAmount.length; i++) {
            coinAmount[i] = object.nextInt();
        }
        System.out.println(solution(cents, coinAmount));
    }
    public static int solution(int total, int[] coins) {
        int[] dp = new int[total + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= total; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[total];
    }
}
