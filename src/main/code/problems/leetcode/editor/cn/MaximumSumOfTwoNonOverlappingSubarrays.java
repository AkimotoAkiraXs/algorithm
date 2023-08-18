// Given an integer array nums and two integers firstLen and secondLen, return
// the maximum sum of elements in two non-overlapping subarrays with lengths
// firstLen and secondLen.
//
// The array with length firstLen could occur before or after the array with 
// length secondLen, but they have to be non-overlapping.
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
// Output: 20
// Explanation: One choice of subarrays is [9] with length 1, and [6,5] with
// length 2.
// 
//
// Example 2: 
//
// 
// Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
// Output: 29
// Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with
// length 2.
// 
//
// Example 3: 
//
// 
// Input: nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
// Output: 31
// Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [0,3,8]
// with length 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= firstLen, secondLen <= 1000 
// 2 <= firstLen + secondLen <= 1000 
// firstLen + secondLen <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 滑动窗口 👍 259 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1031
 * <p>
 * Name：Maximum Sum of Two Non-Overlapping Subarrays
 *
 * @author Yuri
 * @since 2023-06-07 14:22:45
 */


public class MaximumSumOfTwoNonOverlappingSubarrays {
    public static void main(String[] args) {
        Solution solution = new MaximumSumOfTwoNonOverlappingSubarrays().new Solution();
        solution.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3);

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * self 前缀和+滑动窗口，先用left、right记录firstLen长度下子数组的最大值 <br>
         * 然后滑动secondLen长度子数组，每次滑动都比较left、right（分别是firstLen在左边或者在右边的情况）取最大值即为答案
         * <p>
         * 此外，也可以用dp[i]表示0~i数组中长度为firstLen/secondLen子数组最大和，然后滑动secondLen/firstLen窗口。
         * 取两者最大即可，总体来说两种方式思路是一样的
         */
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int ans = Integer.MIN_VALUE;
            int n = nums.length;
            int[] left = new int[n + 1];
            int[] right = new int[n + 1];
            int k = 0;
            for (int i = 0; i < firstLen - 1; i++) k += nums[i];
            for (int i = firstLen; i <= n; i++) {
                k += nums[i - 1];
                left[i] = Math.max(left[i - 1], k);
                k -= nums[i - firstLen];
            }
            k = 0;
            for (int i = n - 1; i > n - firstLen; i--) k += nums[i];
            for (int i = n - firstLen; i >= 0; i--) {
                k += nums[i];
                right[i] = Math.max(right[i + 1], k);
                k -= nums[i + firstLen - 1];
            }
            k = 0;
            for (int i = 0; i < secondLen - 1; i++) k += nums[i];
            for (int i = secondLen - 1; i < n; i++) {
                k += nums[i];
                int l = i - secondLen + 1;
                int r = i + 1;
                ans = Math.max(ans, k + Math.max(left[l], right[r]));
                k -= nums[l];
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
