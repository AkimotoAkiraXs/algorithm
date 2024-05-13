// You are given an integer array nums and a positive integer k.
//
// Return the number of subarrays where the maximum element of nums appears at 
// least k times in that subarray.
//
// A subarray is a contiguous sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,3,2,3,3], k = 2
// Output: 6
// Explanation: The subarrays that contain the element 3 at least 2 times are: [1
//,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
// 
//
// Example 2: 
//
// 
// Input: nums = [1,4,2,1], k = 3
// Output: 0
// Explanation: No subarray contains the element 4 at least 3 times.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 1 <= k <= 10⁵ 
// 
//
// 👍 33 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2962
 * <p>
 * Name：Count Subarrays Where Max Element Appears at Least K Times
 *
 * @author Yuri
 * @since 2024-05-11 17:44:51
 */

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    public static void main(String[] args) {
        Solution solution = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countSubarrays(int[] nums, int k) {
            int max = Arrays.stream(nums).max().getAsInt();
            int n = nums.length;
            long cnt = 0;
            for (int l = 0, r = 0; r < n; r++) {
                if (nums[r] == max) k--;
                while (k == 0) {
                    cnt += n - r;
                    if (nums[l++] == max) k++;
                }
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}