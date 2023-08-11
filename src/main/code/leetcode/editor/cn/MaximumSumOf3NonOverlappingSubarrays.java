// Given an integer array nums and an integer k, find three non-overlapping
// subarrays of length k with maximum sum and return them.
//
// Return the result as a list of indices representing the starting position of 
// each interval (0-indexed). If there are multiple answers, return the
// lexicographically smallest one.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,1,2,6,7,5,1], k = 2
// Output: [0,3,5]
// Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting
// indices [0, 3, 5].
// We could have also taken [2, 1], but an answer of [1, 3, 5] would be
// lexicographically larger.
// 
//
// Example 2: 
//
// 
// Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
// Output: [0,2,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] < 2¹⁶ 
// 1 <= k <= floor(nums.length / 3) 
// 
//
// Related Topics 数组 动态规划 👍 338 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;689
 * <p>
 * Name：Maximum Sum of 3 Non-Overlapping Subarrays
 *
 * @author Yuri
 * @since 2023-06-06 14:24:10
 */


public class MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args) {
        Solution solution = new MaximumSumOf3NonOverlappingSubarrays().new Solution();
        solution.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Dp+前缀和：dp[i][j]表示字符串长度为j时，i个子数组的最大值，转移公式为：max(dp[i][j-1], dp[i-1][j-k]+Sum{j-k+1, j})
         * <p>
         * preSum前缀和用与快速计算区间数组
         * <p>
         * ans是记录坐标，为了能同时记录三个数以2*10000为模
         */
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            long mod = 2 * 10000;
            int n = nums.length;
            long[][] ans = new long[4][n + 1];
            int[][] dp = new int[4][n + 1];
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + nums[i - 1];
            for (int i = 1; i <= 3; i++) {
                for (int j = k; j <= n; j++) {
                    if (dp[i - 1][j - k] + preSum[j] - preSum[j - k] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j - k] + preSum[j] - preSum[j - k];
                        ans[i][j] = (j - k) + ans[i - 1][j - k] * mod;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        ans[i][j] = ans[i][j - 1];
                    }
                }
            }
            return new int[]{(int) (ans[3][n] / Math.pow(mod, 2)), (int) (ans[3][n] / Math.pow(mod, 1) % mod), (int) (ans[3][n] % mod)};
        }

        public int[] maxSumOfThreeSubarraysSliding(int[] nums, int k) {
            int[] ans = new int[3];
            int n = nums.length;
            // maxOfOne：第一个数组的最大值；sumOfOne：滑动时第一个数组的和；maxOfOneIndex：第一个数组得到最大值时的起始坐标
            int maxOfOne = 0, sumOfOne = 0, maxOfOneIndex = 0;
            // maxOfOneTwo1Index：当两个数组在某段取得最大值时第一个数组的起始坐标；maxOfOneTwo2Index：...第二个数组的起始坐标
            int sumOfTwo = 0, maxOfOneTwo = 0, maxOfOneTwo1Index = 0, maxOfOneTwo2Index = 0;
            int sumOfThree = 0, maxOfTwoThree = 0;
            for (int i = 0; i < n - 2 * k; i++) {
                sumOfOne += nums[i];
                sumOfTwo += nums[i + k];
                sumOfThree += nums[i + 2 * k];
                if (i >= k - 1) {
                    if (sumOfOne > maxOfOne) {
                        maxOfOne = sumOfOne;
                        maxOfOneIndex = i - k + 1;
                    }
                    if (sumOfTwo + maxOfOne > maxOfOneTwo) {
                        maxOfOneTwo = sumOfTwo + maxOfOne;
                        maxOfOneTwo1Index = maxOfOneIndex;
                        maxOfOneTwo2Index = i + 1;
                    }
                    if (sumOfThree + maxOfOneTwo > maxOfTwoThree) {
                        maxOfTwoThree = sumOfThree + maxOfOneTwo;
                        ans[0] = maxOfOneTwo1Index;
                        ans[1] = maxOfOneTwo2Index;
                        ans[2] = i + k + 1;
                    }
                    sumOfOne -= nums[i - k + 1];
                    sumOfTwo -= nums[i + 1];
                    sumOfThree -= nums[i + k + 1];
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
