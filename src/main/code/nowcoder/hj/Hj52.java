package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/10 19:42
 */
public class Hj52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sx = in.nextLine();
        String sy = in.nextLine();
        int m = sx.length();
        int n = sy.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + 1;
        for (int i = 1; i <= n; i++) dp[0][i] = dp[0][i - 1] + 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (sx.charAt(i - 1) == sy.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        System.out.println(dp[m][n]);
    }
}
