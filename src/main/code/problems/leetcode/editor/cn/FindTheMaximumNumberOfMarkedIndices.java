// You are given a 0-indexed integer array nums.
//
// Initially, all of the indices are unmarked. You are allowed to make this 
// operation any number of times:
//
// 
// Pick two different unmarked indices i and j such that 2 * nums[i] <= nums[j],
// then mark i and j. 
// 
//
// Return the maximum possible number of marked indices in nums using the above 
// operation any number of times.
//
// 
// Example 1: 
//
// 
// Input: nums = [3,5,2,4]
// Output: 2
// Explanation: In the first operation: pick i = 2 and j = 1, the operation is
// allowed because 2 * nums[2] <= nums[1]. Then mark index 2 and 1.
// It can be shown that there's no other valid operation so the answer is 2.
// 
//
// Example 2: 
//
// 
// Input: nums = [9,2,5,4]
// Output: 4
// Explanation: In the first operation: pick i = 3 and j = 0, the operation is
// allowed because 2 * nums[3] <= nums[0]. Then mark index 3 and 0.
// In the second operation: pick i = 1 and j = 2, the operation is allowed
// because 2 * nums[1] <= nums[2]. Then mark index 1 and 2.
// Since there is no other operation, the answer is 4.
// 
//
// Example 3: 
//
// 
// Input: nums = [7,6,8]
// Output: 0
// Explanation: There is no valid operation to do, so the answer is 0.
//
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
// 
// 
//
// 👍 53 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2576
 * <p>
 * Name：Find the Maximum Number of Marked Indices
 *
 * @author Yuri
 * @since 2024-08-27 15:00:55
 */

public class FindTheMaximumNumberOfMarkedIndices {

    public static void main(String[] args) {
        Solution solution = new FindTheMaximumNumberOfMarkedIndices().new Solution();
        solution.maxNumOfMarkedIndices(new int[]{9, 2, 5, 4});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 可以想到答案一定在0~n之间，将nums排序，贪心而言，如果答案是k那一定是在nums中取前k/2个和后k/2个，所以根据是否满足这个条件进行二分
         */
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int l = 0, r = n / 2;
            while (l <= r) {
                int m = l + r >> 1;
                boolean f = true;
                for (int i = 0; i < m; i++) {
                    if (nums[i] * 2 > nums[n - m + i]) {
                        r = m - 1;
                        f = false;
                        break;
                    }
                }
                if (f) l = m + 1;
                else r = m - 1;
            }
            return r * 2;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}