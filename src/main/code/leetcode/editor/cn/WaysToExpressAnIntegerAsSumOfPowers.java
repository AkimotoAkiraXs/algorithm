package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2787 <br/>
 * Name：Ways to Express an Integer as Sum of Powers <br/>
 *
 * @author Yuri
 * @since 2023-07-26 00:30:52
 */

public class WaysToExpressAnIntegerAsSumOfPowers {
    public static void main(String[] args) {
        Solution solution = new WaysToExpressAnIntegerAsSumOfPowers().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 很裸的01背包，没想到属实是不做人了
        public int numberOfWays(int n, int x) {
            int MOD = (int) 1e9 + 7;
            long[] dp = new long[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                int pow = (int) Math.pow(i, x);
                for (int j = n; j >= pow; j--)
                    dp[j] = (dp[j] + dp[j - pow]) % MOD;
            }
            return (int) dp[n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
