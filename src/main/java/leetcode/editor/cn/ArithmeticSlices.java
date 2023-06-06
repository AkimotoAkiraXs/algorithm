// An integer array is called arithmetic if it consists of at least three
// elements and if the difference between any two consecutive elements is the same.
//
// 
// For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic 
// sequences.
// 
//
// Given an integer array nums, return the number of arithmetic subarrays of 
// nums.
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,4]
// Output: 3
// Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,
// 2,3,4] itself.
// 
//
// Example 2: 
//
// 
// Input: nums = [1]
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 537 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;413
 * <p>
 * Name：Arithmetic Slices
 *
 * @author Yuri
 * @since 2023-06-06 14:40:13
 */


public class ArithmeticSlices {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlices().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int ans = 0;
            int cnt = 0;
            int gap = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (gap == nums[i] - nums[i - 1]) cnt++;
                else {
                    gap = nums[i] - nums[i - 1];
                    ans += (int) ((1 + cnt) * cnt / 2.0); // 这里也可以不推公式，通过Dp进行计算：dp[i] = dp[i - 1] + 1; ans += dp[i];
                    cnt = 0;
                }
            }
            ans += (int) ((1 + cnt) * cnt / 2.0);
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
