// You are given an array nums that consists of non-negative integers. Let us
// define rev(x) as the reverse of the non-negative integer x. For example, rev(123) =
// 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all 
// of the following conditions:
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// Return the number of nice pairs of indices. Since that number can be too 
// large, return it modulo 10⁹ + 7.
//
// 
// Example 1: 
//
// 
// Input: nums = [42,11,1,97]
// Output: 2
// Explanation: The two pairs are:
// - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
// - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
// 
//
// Example 2: 
//
// 
// Input: nums = [13,10,35,24,76]
// Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 125 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;1814
 * <p>
 * Name：Count Nice Pairs in an Array
 *
 * @author Yuri
 * @since 2024-09-29 10:10:26
 */

public class CountNicePairsInAnArray {

    public static void main(String[] args) {
        Solution solution = new CountNicePairsInAnArray().new Solution();
        solution.countNicePairs(new int[]{42, 11, 1, 97});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countNicePairs(int[] nums) {
            int mod = (int) (1e9 + 7);
            Map<Integer, Integer> map = new HashMap<>();
            long ans = 0;
            for (int num : nums) {
                int rev = num - rev(num);
                ans = (ans + map.getOrDefault(rev, 0)) % mod;
                map.merge(rev, 1, Integer::sum);
            }
            return (int) ans;
        }

        private int rev(int n) {
            return Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}