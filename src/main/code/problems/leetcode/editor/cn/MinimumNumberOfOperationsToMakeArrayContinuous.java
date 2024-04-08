//You are given an integer array nums. In one operation, you can replace any 
//element in nums with any integer. 
//
// nums is considered continuous if both of the following conditions are 
//fulfilled: 
//
// 
// All elements in nums are unique. 
// The difference between the maximum element and the minimum element in nums 
//equals nums.length - 1. 
// 
//
// For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] 
//is not continuous. 
//
// Return the minimum number of operations to make nums continuous. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,5,3]
//Output: 0
//Explanation: nums is already continuous.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5,6]
//Output: 1
//Explanation: One possible solution is to change the last element to 4.
//The resulting array is [1,2,3,5,4], which is continuous.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,10,100,1000]
//Output: 3
//Explanation: One possible solution is to:
//- Change the second element to 2.
//- Change the third element to 3.
//- Change the fourth element to 4.
//The resulting array is [1,2,3,4], which is continuous.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 70 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2009
 * <p>
 * Name：Minimum Number of Operations to Make Array Continuous
 *
 * @author Yuri
 * @since 2024-04-08 14:48:08
 */

public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfOperationsToMakeArrayContinuous().new Solution();
        solution.minOperations(new int[]{4, 2, 5, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针+正难则返
         * <p>
         * 把问题转换为“最多可以留多少个数字不转换”。
         * 按题目要求，最后数组会转换为长度为n的连续不重复数组，所以排序后去掉重复元素（重复元素一定会变更），
         * 在剩余数组中用一个长度为n的滑动窗口，得到窗口中能获取的最多的元素个数m，n-m则是答案。
         */
        public int minOperations(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int p = 1;
            // 原地去重
            for (int i = 1; i < n; i++)
                if (nums[i] != nums[i - 1]) nums[p++] = nums[i];

            int r = 0, cnt = 0;
            for (int l = 0; l < p; l++) {
                while (r < p && nums[l] + n > nums[r]) r++;
                cnt = Math.max(cnt, r - l);
            }
            return n - cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}