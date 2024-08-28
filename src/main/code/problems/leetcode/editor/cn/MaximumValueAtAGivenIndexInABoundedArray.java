// You are given three positive integers: n, index, and maxSum. You want to
// construct an array nums (0-indexed) that satisfies the following conditions:
//
// 
// nums.length == n 
// nums[i] is a positive integer where 0 <= i < n. 
// abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1. 
// The sum of all the elements of nums does not exceed maxSum. 
// nums[index] is maximized. 
// 
//
// Return nums[index] of the constructed array. 
//
// Note that abs(x) equals x if x >= 0, and -x otherwise. 
//
// 
// Example 1: 
//
// 
// Input: n = 4, index = 2,  maxSum = 6
// Output: 2
// Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
// There are no arrays that satisfy all the conditions and have nums[2] == 3, so
// 2 is the maximum nums[2].
// 
//
// Example 2: 
//
// 
// Input: n = 6, index = 1,  maxSum = 10
// Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= maxSum <= 10⁹ 
// 0 <= index < n 
// 
//
// 👍 218 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1802
 * <p>
 * Name：Maximum Value at a Given Index in a Bounded Array
 *
 * @author Yuri
 * @since 2024-08-28 11:15:29
 */

public class MaximumValueAtAGivenIndexInABoundedArray {

    public static void main(String[] args) {
        Solution solution = new MaximumValueAtAGivenIndexInABoundedArray().new Solution();
        System.out.println(solution.maxValue(4, 0, 4));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxValue(int n, int index, int maxSum) {
            int l = 1, r = maxSum;
            while (l <= r) {
                int m = l + r >> 1;
                long sum = 0;
                // 计算左边和（不包含nums[index]本身）
                if (index < m) sum += (long) index * (m - 1 + (m - index)) / 2;
                else sum += (long) (m - 1) * (1 + m - 1) / 2 + index - (m - 1);
                // 计算右边和（包含nums[index]本身）
                if (n - index < m) sum += (long) (m + m - (n - index - 1)) * (n - index) / 2;
                else sum += (long) m * (1 + m) / 2 + (n - index) - m;
                // 二分
                if (sum <= maxSum) l = m + 1;
                else r = m - 1;
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}