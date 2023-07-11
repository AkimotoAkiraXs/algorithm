// The alternating sum of a 0-indexed array is defined as the sum of the
// elements at even indices minus the sum of the elements at odd indices.
//
// 
// For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4. 
// 
//
// Given an array nums, return the maximum alternating sum of any subsequence 
// of nums (after reindexing the elements of the subsequence).
//
// 
// 
//
// A subsequence of an array is a new array generated from the original array 
// by deleting some elements (possibly none) without changing the remaining
// elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the
// underlined elements), while [2,4,2] is not.
//
// 
// Example 1: 
//
// 
// Input: nums = [4,2,5,3]
// Output: 7
// Explanation: It is optimal to choose the subsequence [4,2,5] with alternating
// sum (4 + 5) - 2 = 7.
// 
//
// Example 2: 
//
// 
// Input: nums = [5,6,7,8]
// Output: 8
// Explanation: It is optimal to choose the subsequence [8] with alternating sum
// 8.
// 
//
// Example 3: 
//
// 
// Input: nums = [6,2,1,2,4,5]
// Output: 10
// Explanation: It is optimal to choose the subsequence [6,1,5] with alternating
// sum (6 + 5) - 1 = 10.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 👍 129 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1911
 * <p>
 * Name：Maximum Alternating Subsequence Sum
 * <p>
 * see：{@link BestTimeToBuyAndSellStockWithCooldown 买卖股票的最佳时期II}
 *
 * @author Yuri
 * @since 2023-07-11 17:40:38
 */


public class MaximumAlternatingSubsequenceSum {
    public static void main(String[] args) {
        Solution solution = new MaximumAlternatingSubsequenceSum().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Dp：01背包，dp[i][0]表示0-i的子串中选出的偶数子序列的最大值，dp[i][1]表示奇数子序列最大值
         */
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            long[][] dp = new long[n][2];

            dp[0][0] = 0;
            dp[0][1] = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
            }
            return dp[n - 1][1];
        }


        /**
         * 贪心：
         * <p>
         * 我们首先维护一个数max作为最后一个奇数（不用减去偶数），此时ans最大值也就是max。
         * 当遇到num[i]<=num[i-1]时，ans最大值<=max，所以我们不动。<br>
         * 当遇到num[i]>num[i-1]时，我们此时如果拿去nums[i]，ans最大值为max+num[i]-num[i-1]，所以我们更新答案。
         */
        public long maxAlternatingSum_greed(int[] nums) {
            int n = nums.length;
            long ans = 0;
            int max;
            max = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    ans += max - nums[i - 1];
                    max = nums[i];
                }
            }
            return ans + max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
