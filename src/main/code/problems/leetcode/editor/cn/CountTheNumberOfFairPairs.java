// Given a 0-indexed integer array nums of size n and two integers lower and
// upper, return the number of fair pairs.
//
// A pair (i, j) is fair if: 
//
// 
// 0 <= i < j < n, and 
// lower <= nums[i] + nums[j] <= upper 
// 
//
// 
// Example 1: 
//
// 
// Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
// Output: 6
// Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1
//,5).
// 
//
// Example 2: 
//
// 
// Input: nums = [1,7,9,2,5], lower = 11, upper = 11
// Output: 1
// Explanation: There is a single fair pair: (2,3).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums.length == n 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= lower <= upper <= 10⁹ 
// 
//
// 👍 70 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2563
 * <p>
 * Name：Count the Number of Fair Pairs
 *
 * @author Yuri
 * @since 2024-08-15 11:33:07
 */

public class CountTheNumberOfFairPairs {

    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfFairPairs().new Solution();
        System.out.println(solution.countFairPairs(new int[]{0, 0, 0, 0, 0, 0}, 0, 0));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分法
         */
        public long countFairPairs_(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            long ans = 0;
            for (int i = 0; i < nums.length; i++)
                ans += dichotomy(nums, upper + 1 - nums[i], i + 1) - dichotomy(nums, lower - nums[i], i + 1);
            return ans;
        }

        private int dichotomy(int[] nums, int t, int l) {
            int r = nums.length;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < t) l = mid + 1;
                else r = mid;
            }
            return l;
        }

        /**
         * 三指针
         */
        public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            int l = nums.length, r = nums.length;
            long ans = 0;
            for (int i = 0; i < nums.length; i++) {
                while (l > 0 && nums[l - 1] + nums[i] >= lower) l--;
                while (r > 0 && nums[r - 1] + nums[i] > upper) r--;
                ans += Math.min(r, i) - Math.min(l, i); // 只计算i作为一对数右边的数位置，避免了重复计算和计算到自身
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}