package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/14 20:06
 */


public class Hj61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][1] = 1; // 无论几个苹果只要有一个盘子就是一种方案
        for (int i = 1; i <= n; i++) dp[0][i] = dp[1][i] = 1; // 有一个苹果，一个以上的盘子就是一种方案，没有盘子则不算一种方案

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < j) dp[i][j] = dp[i][i]; // 苹果<盘子 则必有j-i个盘子空着，所以其实就相当于只有i个盘子
                else dp[i][j] = dp[i][j - 1] + dp[i - j][j]; // 苹果>盘子 则分两种情况：
                // ①.至少有一个盘子空着，dp[i][j-1]，因为其包含了dp[i][j-2]的结果，所以其实也涵盖了2...n-1个盘子空着的可能
                // ②.没有盘子空着，则至少每个盘子有一个苹果。dp[i-j][j]
            }
        }
        System.out.println(dp[m][n]);
    }
}
