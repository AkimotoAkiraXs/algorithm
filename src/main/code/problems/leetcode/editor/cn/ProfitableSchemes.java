// There is a group of n members, and a list of various crimes they could commit.
// The iᵗʰ crime generates a profit[i] and requires group[i] members to 
// participate in it. If a member participates in one crime, that member can't participate
// in another crime.
//
// Let's call a profitable scheme any subset of these crimes that generates at 
// least minProfit profit, and the total number of members participating in that
// subset of crimes is at most n.
//
// Return the number of schemes that can be chosen. Since the answer may be 
// very large, return it modulo 10⁹ + 7.
//
// 
// Example 1: 
//
// 
// Input: n = 5, minProfit = 3, group = [2,2], profit = [2,3]
// Output: 2
// Explanation: To make a profit of at least 3, the group could either commit
// crimes 0 and 1, or just crime 1.
// In total, there are 2 schemes.
//
// Example 2: 
//
// 
// Input: n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
// Output: 7
// Explanation: To make a profit of at least 5, the group could commit any
// crimes, as long as they commit one.
// There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 100 
// 0 <= minProfit <= 100 
// 1 <= group.length <= 100 
// 1 <= group[i] <= 100 
// profit.length == group.length 
// 0 <= profit[i] <= 100 
// 
//
// 👍 280 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;879
 * <p>
 * Name：Profitable Schemes
 *
 * @author Yuri
 * @since 2023-07-26 16:32:52
 */


public class ProfitableSchemes {
    public static void main(String[] args) {
        Solution solution = new ProfitableSchemes().new Solution();
        solution.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 01背包进阶题-多维背包
         * <p>
         * 状态方程不难推，难的是初始化定义，需要弄清楚j代表的含义后再确定初始化和答案该如何计算
         * <p>
         * 下方两种三维dp中j分别代表不同含义，其中会影响初始化定义和最后答案的求解，十分巧妙
         */
        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            int mod = (int) 1e9 + 7;
            int len = group.length;
            int[][] dp = new int[n + 1][minProfit + 1];
            for (int j = 0; j <= n; j++) dp[j][0] = 1;
            for (int i = 1; i <= len; i++) {
                for (int j = n; j >= 0; j--) {
                    for (int k = 0; k <= minProfit; k++) {
                        dp[j][k] = dp[j][k];
                        if (j >= group[i - 1])
                            dp[j][k] = (dp[j][k] + dp[j - group[i - 1]][Math.max(0, k - profit[i - 1])]) % mod;
                    }
                }
            }
            return dp[n][minProfit];
        }

        // dp[i][j][k]中j表示员工数至少为j
        public int profitableSchemes_least(int n, int minProfit, int[] group, int[] profit) {
            int mod = (int) 1e9 + 7;
            int len = group.length;
            int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
            // 因为第二维表示使用人数至少为j，所以后面的j应该加上前面j的结果，下面循环i从1开始所以需要对所有dp[0][j][0]做初始化
            for (int j = 0; j <= n; j++) dp[0][j][0] = 1;
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j <= n; j++) {
                    for (int k = 0; k <= minProfit; k++) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j >= group[i - 1])
                            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])]) % mod;
                    }
                }
            }
            return dp[len][n][minProfit]; // n表示了使用人数至少为n，所以直接返回
        }

        // dp[i][j][k]中j表示员工数为j
        public int profitableSchemes_is(int n, int minProfit, int[] group, int[] profit) {
            int mod = (int) 1e9 + 7;
            int len = group.length;
            int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
            // 与上面不同，j表示使用人数为j，所以只有dp[0][0][0]需要初始化（其余dp[0][j][0]=0）
            dp[0][0][0] = 1;
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j <= n; j++) {
                    for (int k = 0; k <= minProfit; k++) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j >= group[i - 1])
                            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])]) % mod;
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i <= n; i++) sum = (sum + dp[len][i][minProfit]) % mod; // 需要把0~n员工的答案都加起来
            return (int) sum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
