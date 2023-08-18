// Given an integer array nums of 2n integers, group these integers into n pairs
//(a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is 
// maximized. Return the maximized sum.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,4,3,2]
// Output: 4
// Explanation: All possible pairings (ignoring the ordering of elements) are:
// 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
// 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
// 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
// So the maximum possible sum is 4.
//
// Example 2: 
//
// 
// Input: nums = [6,2,6,5,1,2]
// Output: 9
// Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2,
// 5) + min(6, 6) = 1 + 2 + 6 = 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// nums.length == 2 * n 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 计数排序 排序 👍 338 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;561
 * <p>
 * Name：Array Partition
 *
 * @author Yuri
 * @since 2023-04-26 17:00:07
 */


public class ArrayPartition {
    public static void main(String[] args) {
        Solution solution = new ArrayPartition().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int cnt = 0;
            for (int i = 0; i < nums.length; i += 2) cnt += nums[i];
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
