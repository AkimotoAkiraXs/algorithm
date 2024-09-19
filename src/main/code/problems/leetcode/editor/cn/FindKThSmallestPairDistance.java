// The distance of a pair of integers a and b is defined as the absolute
// difference between a and b.
//
// Given an integer array nums and an integer k, return the kᵗʰ smallest 
// distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,3,1], k = 1
// Output: 0
// Explanation: Here are all the pairs:
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
// Then the 1ˢᵗ smallest distance pair is (1,1), and its distance is 0.
// 
//
// Example 2: 
//
// 
// Input: nums = [1,1,1], k = 2
// Output: 0
// 
//
// Example 3: 
//
// 
// Input: nums = [1,6,1], k = 3
// Output: 5
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 10⁴ 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= n * (n - 1) / 2 
// 
//
// 👍 459 👎 0

package problems.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Id：&emsp;&emsp;719
 * <p>
 * Name：Find K-th Smallest Pair Distance
 *
 * @author Yuri
 * @since 2024-09-18 16:24:19
 */

public class FindKThSmallestPairDistance {

    public static void main(String[] args) {
        Solution solution = new FindKThSmallestPairDistance().new Solution();
        solution.smallestDistancePair(new int[]{1, 6, 1}, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分+滑动窗口：二分所有可能得距离，求满足该距离的对数和k作比较
         */
        public int smallestDistancePair(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            int l = 0, r = nums[n - 1] - nums[0];
            while (l <= r) {
                int m = (r - l >> 1) + l;
                long cnt = 0;
                for (int i = 0, j = 0; i < n; i++) {
                    while (j < i && nums[i] - nums[j] > m) j++;
                    cnt += i - j;
                }
                if (cnt < k) l = m + 1;
                else r = m - 1;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}