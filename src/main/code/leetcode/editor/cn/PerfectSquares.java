// Given an integer n, return the least number of perfect square numbers that
// sum to n.
//
// A perfect square is an integer that is the square of an integer; in other 
// words, it is the product of some integer with itself. For example, 1, 4, 9, and 16
// are perfect squares while 3 and 11 are not.
//
// 
// Example 1: 
//
// 
// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1722 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;279
 * <p>
 * Name：Perfect Squares
 *
 * @author Yuri
 * @since 2023-06-12 15:42:41
 */


public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares(5));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 朴素完全背包dp，有超时风险
        public int numSquares_(int n) {
            int sqrt = (int) Math.sqrt(n);
            var dp = new int[sqrt + 1][n + 1];
            for (int i = 1; i <= sqrt; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int i = 1; i <= sqrt; i++) dp[i][0] = 0;
            // i=1时i-1=0，没有意义，所以这里提前处理只能选1的情况
            for (int i = 0; i <= n; i++) dp[1][i] = i;
            // i除了代表顺序，也要作为实际数字参与运算（i*i），所以这里让dp[0]浪费也要让i从正式的1开始（但1提前处理了，所以这里是从2开始
            for (int i = 2; i <= sqrt; i++)
                for (int j = 1; j <= n; j++) {
                    for (int k = 0; k * i * i <= j; k++)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * i * i] + k);
/*
                    // 优化但不降维：降维和优化无直接关系，可以优化但不降维，也可以降维而不优化
                    if (j < i * i) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i * i] + 1);
*/
                }
            return dp[sqrt][n];
        }

        // 一维优化
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            int sqrt = (int) Math.sqrt(n);
            dp[0] = 0;
            for (int i = 1; i <= sqrt; i++)
                for (int j = i * i; j <= n; j++)
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            return dp[n];
        }

        // 一维优化：i，j角色反转版代码
        public int numSquares_reverse(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            int sqrt = (int) Math.sqrt(n);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sqrt && j * j <= i; j++)
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
            return dp[n];
        }

        // 数学：四平方和定理
        public int numSquares_math(int n) {
            // 判断n最少可以被几个正整数完全平方和表示
            int x = n;

            // 先判断是否满足n=4^k*(8*m+7)
            while (x % 4 == 0) x /= 4;
            if (x % 8 == 7) return 4;

            // 判断本身是不是平方数
            if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) return 1;

            // 判断是否为两个数的平方
            for (int i = 1; i * i <= n; i++) {
                int j = n - i * i;
                if ((int) Math.sqrt(j) * (int) Math.sqrt(j) == j) {
                    return 2;
                }
            }

            // 都不是则只有3了
            return 3;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
