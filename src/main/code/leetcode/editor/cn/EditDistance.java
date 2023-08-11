package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;72
 * <p>
 * Name：编辑距离
 * dp:
 *
 * @author Yuri
 * @since 2023-04-07 19:36:46
 */


public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + 1;
            for (int i = 1; i <= n; i++) dp[0][i] = dp[0][i - 1] + 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
