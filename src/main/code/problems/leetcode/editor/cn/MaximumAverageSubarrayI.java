//You are given an integer array nums consisting of n elements, and an integer 
//k. 
//
// Find a contiguous subarray whose length is equal to k that has the maximum 
//average value and return this value. Any answer with a calculation error less 
//than 10⁻⁵ will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,12,-5,-6,50,3], k = 4
//Output: 12.75000
//Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
// 
//
// Example 2: 
//
// 
//Input: nums = [5], k = 1
//Output: 5.00000
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= k <= n <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 👍 334 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;643
 * <p>
 * Name：Maximum Average Subarray I
 *
 * @author Yuri
 * @since 2024-04-10 17:38:29
 */

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();

        solution.findMaxAverage(new int[]{-1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int l = 0;
            double max = -1e4;
            int sum = 0;
            for (int r = 0; r < nums.length; r++) {
                if (r - l >= k) sum -= nums[l++];
                sum += nums[r];
                if (r - l == k - 1) max = Math.max(max, (double) sum / k);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}