// You are given two positive integer arrays nums1 and nums2, both of length n.
//
// The absolute sum difference of arrays nums1 and nums2 is defined as the sum 
// of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
//
// You can replace at most one element of nums1 with any other element in nums1 
// to minimize the absolute sum difference.
//
// Return the minimum absolute sum difference after replacing at most one 
// element in the array nums1. Since the answer may be large, return it modulo 10⁹ + 7.
//
// |x| is defined as: 
//
// 
// x if x >= 0, or 
// -x if x < 0. 
// 
//
// 
// Example 1: 
//
// 
// Input: nums1 = [1,7,5], nums2 = [2,3,5]
// Output: 3
// Explanation: There are two possible optimal solutions:
//- Replace the second element with the first: [1,7,5] => [1,1,5], or
//- Replace the second element with the third: [1,7,5] => [1,5,5].
// Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5|
// = 3.
// 
//
// Example 2: 
//
// 
// Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
// Output: 0
// Explanation: nums1 is equal to nums2 so no replacement is needed. This will
// result in an
// absolute sum difference of 0.
// 
//
// Example 3: 
//
// 
// Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
// Output: 20
// Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,
// 10,4,4,2,7].
// This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2
//-7| + |7-4| = 20
// 
//
// 
// Constraints: 
//
// 
// n == nums1.length 
// n == nums2.length 
// 1 <= n <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 10⁵ 
// 
//
// 👍 167 👎 0

package problems.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Id：&emsp;&emsp;1818
 * <p>
 * Name：Minimum Absolute Sum Difference
 *
 * @author Yuri
 * @since 2024-08-16 10:36:25
 */

public class MinimumAbsoluteSumDifference {

    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteSumDifference().new Solution();
        solution.minAbsoluteSumDiff(
            new int[]{56, 51, 39, 1, 12, 14, 58, 82, 18, 41, 70, 64, 18, 7, 44, 90, 55, 23, 11, 79, 59, 76, 67, 92, 60,
                80, 57, 11, 66, 32, 76, 73, 35, 65, 55, 37, 38, 26, 4, 7, 64, 84, 98, 61, 78, 1, 80, 33, 5, 66, 32, 30,
                52, 29, 41, 2, 21, 83, 30, 35, 21, 30, 13, 26, 36, 93, 81, 41, 98, 23, 20, 19, 45, 52, 25, 51, 52, 24,
                2, 45, 21, 97, 11, 92, 28, 37, 58, 29, 5, 18, 98, 94, 86, 65, 88, 8, 75, 12, 9, 66},
            new int[]{64, 32, 98, 65, 67, 40, 71, 93, 74, 24, 49, 80, 98, 35, 86, 52, 99, 65, 15, 92, 83, 84, 80, 71,
                46, 11, 26, 70, 80, 2, 81, 57, 97, 12, 68, 10, 49, 80, 24, 18, 45, 72, 33, 94, 60, 5, 94, 99, 14, 41,
                25, 83, 77, 67, 49, 70, 94, 83, 55, 17, 61, 44, 50, 62, 3, 36, 67, 10, 2, 39, 53, 62, 44, 72, 66, 7, 3,
                6, 80, 38, 43, 100, 17, 25, 24, 78, 8, 4, 36, 86, 9, 68, 99, 64, 65, 15, 42, 59, 79, 66});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 对num1排序然后遍历nums2在nums1中二分查找最近的数，记录贡献最大值
         */
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            long total = 0;
            for (int i = 0; i < nums1.length; i++)
                total += Math.abs(nums2[i] - nums1[i]);
            int mod = (int) (1e9 + 7);
            int n = nums1.length;
            int[] nums = Arrays.copyOf(nums1, n);
            Arrays.sort(nums);
            int max = 0;
            for (int i = 0; i < n; i++) {
                int x = dichotomy(nums, nums2[i]);// x是大于nums2[i]的第一个数，所以x-1是小于等于nums2[i]的第一个数，最小绝对值就在这两数之间
                if (x == n || (x > 0 && Math.abs(nums2[i] - nums[x]) > Math.abs(nums2[i] - nums[x - 1]))) x = x - 1;
                max = Math.max(max, Math.abs(nums2[i] - nums1[i]) - Math.abs(nums[x] - nums2[i]));
            }
            return (int) ((total - max) % mod); // 注意(int)优先级高于%，所以要加括号
        }

        private int dichotomy(int[] nums, int t) {
            int l = 0, r = nums.length;
            while (l < r) {
                int m = l + r >> 1;
                if (nums[m] < t) l = m + 1;
                else r = m;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}