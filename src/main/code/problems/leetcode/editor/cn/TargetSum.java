package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;494 <br/>
 * Name：目标和 <br/>
 *
 * @author Yuri
 * @since 2023-03-04 08:45:58
 */

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 本题可以用dfs以2^n复杂度暴力，但标准解法是转为01背包问题用动态规划解决，此题难点也是怎么转换为dp思想<br/>
         * 记数组的元素和为 sum，添加 -号的元素之和为 neg，则其余添加 + 的元素之和为 sum − neg，<br/>
         * 得到的表达式的结果为：(sum−neg)−neg=sum−2⋅neg=target ∴ neg = (sum-target)/2 <br/>
         * 如此一来则转换为了经典01背包问题，在nums中选几个数和为neg，求有多少种选法？
         */
        public int findTargetSumWays(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            int k = sum - target;
            if (k % 2 != 0 || k < 0) return 0; // 如果不存在整数neg则表明nums中根本不存在任何一种组合能得到target
            int neg = k / 2;

            int[] dp = new int[neg + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = neg; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }
            return dp[neg];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
