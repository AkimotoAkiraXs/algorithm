// You are given an integer array nums of size n.
//
// Consider a non-empty subarray from nums that has the maximum possible 
// bitwise AND.
//
// 
// In other words, let k be the maximum value of the bitwise AND of any 
// subarray of nums. Then, only subarrays with a bitwise AND equal to k should be
// considered.
// 
//
// Return the length of the longest such subarray. 
//
// The bitwise AND of an array is the bitwise AND of all the numbers in it. 
//
// A subarray is a contiguous sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,3,2,2]
// Output: 2
// Explanation:
// The maximum possible bitwise AND of a subarray is 3.
// The longest subarray with that value is [3,3], so we return 2.
// 
//
// Example 2: 
//
// 
// Input: nums = [1,2,3,4]
// Output: 1
// Explanation:
// The maximum possible bitwise AND of a subarray is 4.
// The longest subarray with that value is [4], so we return 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// 👍 24 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2419
 * <p>
 * Name：Longest Subarray With Maximum Bitwise AND
 *
 * @author Yuri
 * @since 2024-06-25 15:57:40
 */

public class LongestSubarrayWithMaximumBitwiseAnd {

    public static void main(String[] args) {
        Solution solution = new LongestSubarrayWithMaximumBitwiseAnd().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestSubarray(int[] nums) {
            int ans = 0, max = 0;
            int k = Arrays.stream(nums).max().getAsInt();
            for (int num : nums) {
                if (num == k) max = Math.max(max, ++ans);
                else ans = 0;
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}