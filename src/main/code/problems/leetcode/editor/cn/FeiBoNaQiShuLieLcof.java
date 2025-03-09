// English description is not available for the problem. Please switch to
// Chinese.
// 👍 544 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;LCR 126
 * <p>
 * Name：斐波那契数
 *
 * @author Yuri
 * @since 2025-03-09 16:15:49
 */

public class FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Dp
         */
        public int fib(int n) {
            if (n < 2) return n;
            int mod = (int) 1e9 + 7;
            int p = 0, q = 1, r = p + q;
            for (int i = 2; i < n; i++) {
                p = q;
                q = r;
                r = (p + q) % mod;
            }
            return r;
        }

        /**
         * 矩阵快速幂 略
         */
    }
// leetcode submit region end(Prohibit modification and deletion)

}