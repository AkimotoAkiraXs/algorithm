// Given an integer array nums, return the number of all the arithmetic
// subsequences of nums.
//
// A sequence of numbers is called arithmetic if it consists of at least three 
// elements and if the difference between any two consecutive elements is the same.
//
//
// 
// For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are 
// arithmetic sequences.
// For example, [1, 1, 2, 5, 7] is not an arithmetic sequence. 
// 
//
// A subsequence of an array is a sequence that can be formed by removing some 
// elements (possibly none) of the array.
//
// 
// For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10]. 
// 
//
// The test cases are generated so that the answer fits in 32-bit integer. 
//
// 
// Example 1: 
//
// 
// Input: nums = [2,4,6,8,10]
// Output: 7
// Explanation: All arithmetic subsequence slices are:
//[2,4,6]
//[4,6,8]
//[6,8,10]
//[2,4,6,8]
//[4,6,8,10]
//[2,4,6,8,10]
//[2,6,10]
// 
//
// Example 2: 
//
// 
// Input: nums = [7,7,7,7,7]
// Output: 16
// Explanation: Any subsequence of this array is arithmetic.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 动态规划 👍 284 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;446
 * <p>
 * Name：Arithmetic Slices II - Subsequence
 *
 * @author Yuri
 * @since 2023-06-06 17:37:06
 */


public class ArithmeticSlicesIiSubsequence {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlicesIiSubsequence().new Solution();
        int i = solution.numberOfArithmeticSlices(new int[]{2, 4, 6, 6, 8, 10});
        System.out.println(i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Dp：dp[i][g]表示以i结尾，等差为g的等差数列数量，因为g范围过大，所以用Hash表代替
         * <p>
         * 两次for遍历i结尾，i前面数j与i的差值，在j的hash中查找该差值所对应等差数列的值，在此值基础上+1。
         * 因为可能存在相邻相等的数，所以需要再加上i的Hash中该gap的值
         */
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            Map<Long, Integer>[] maps = new Map[n];
            for (int i = 0; i < n; i++) maps[i] = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    long gap = (long) nums[i] - nums[j];
                    Integer cnt = maps[j].getOrDefault(gap, 0);
                    ans += cnt;
                    maps[i].put(gap, maps[i].getOrDefault(gap, 0) + cnt + 1); //maps[i].getOrDefault(gap, 0)为了计算当存在相等数时
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
