// Given an integer array nums, find the subarray with the largest sum, and
// return its sum.
//
// 
// Example 1: 
//
// 
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// 
//
// Example 2: 
//
// 
// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// 
//
// Example 3: 
//
// 
// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
// solution using the divide and conquer approach, which is more subtle.
//
// 👍 6164 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;53
 * <p>
 * Name：Maximum Subarray
 *
 * @author Yuri
 * @since 2023-07-20 11:32:06
 */


public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray_(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1]; // 可以优化空间为O(1)
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
                max = Math.max(dp[i], max);
            }
            return max;
        }

        public int maxSubArray(int[] nums) {
            int pre = 0;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                pre = Math.max(pre + num, num);
                max = Math.max(pre, max);
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
