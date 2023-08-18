package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 14:24
 */
public class Hj91 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt() + 1;
        int y = in.nextInt() + 1;
        int[][] dp = new int[x][y];
        dp[0][0] = 1;
        for (int i = 0; i < x; i++) dp[i][0] = 1;
        for (int i = 0; i < y; i++) dp[0][i] = 1;
        for (int i = 1; i < x; i++)
            for (int j = 1; j < y; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        System.out.println(dp[x - 1][y - 1]);
    }
}
