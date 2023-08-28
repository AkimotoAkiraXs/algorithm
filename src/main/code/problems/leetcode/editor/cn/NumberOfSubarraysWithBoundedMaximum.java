// Given an integer array nums and two integers left and right, return the
// number of contiguous non-empty subarrays such that the value of the maximum array
// element in that subarray is in the range [left, right].
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
// 
//
// 
// Example 1: 
//
// 
// Input: nums = [2,1,4,3], left = 2, right = 3
// Output: 3
// Explanation: There are three subarrays that meet the requirements: [2], [2, 1]
//, [3].
// 
//
// Example 2: 
//
// 
// Input: nums = [2,9,2,5,6], left = 2, right = 8
// Output: 7
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// 👍 358 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;795
 * <p>
 * Name：Number of Subarrays with Bounded Maximum
 *
 * @author Yuri
 * @since 2023-08-21 19:45:09
 */


public class NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        Solution solution = new NumberOfSubarraysWithBoundedMaximum().new Solution();
        solution.numSubarrayBoundedMax(new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52}, 32, 69);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 灵神代码，真的是太精妙了
         * <p>
         * 双指针，每次计算以i为右端符合条件的子数组个数。
         */
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int ans = 0, i0 = -1, i1 = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > right) i0 = i;
                if (nums[i] >= left) i1 = i;
                ans += i1 - i0;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
