package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2786 <br/>
 * Name：Visit Array Positions to Maximize Score <br/>
 *
 * @author Yuri
 * @since 2023-07-25 23:47:29
 */

public class VisitArrayPositionsToMaximizeScore {
    public static void main(String[] args) {
        Solution solution = new VisitArrayPositionsToMaximizeScore().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 优化后的进阶代码：<br>
         * ①.并不需要关心奇偶性，用滚动数组来回滚就行
         * ②.并不需要用max记录答案，最后答案一定在dp中
         */
        public long maxScore(int[] nums, int x) {
            long[] dp = new long[2];
            dp[nums[0] % 2] = nums[0];
            dp[(nums[0] + 1) % 2] = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                dp[num % 2] = Math.max(dp[num % 2] + num, dp[(num + 1) % 2] + num - x);
            }
            return Math.max(dp[0], dp[1]);
        }

        // 比赛写的dp代码，属于又臭又烂了
        public long maxScore_loser(int[] nums, int x) {
            long odd = Integer.MIN_VALUE, even = Integer.MIN_VALUE;
            if ((nums[0] & 1) == 1) odd = nums[0];
            else even = nums[0];
            long max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if ((num & 1) == 1) {
                    odd = Math.max(odd + num, even + num - x);
                    max = Math.max(odd, max);
                } else {
                    even = Math.max(odd + num - x, even + num);
                    max = Math.max(even, max);
                }
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
