//You are given an integer array nums and an integer k. Find the maximum 
//subarray sum of all the subarrays of nums that meet the following conditions: 
//
// 
// The length of the subarray is k, and 
// All the elements of the subarray are distinct. 
// 
//
// Return the maximum subarray sum of all the subarrays that meet the 
//conditions. If no subarray meets the conditions, return 0. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,4,2,9,9,9], k = 3
//Output: 15
//Explanation: The subarrays of nums with length 3 are:
//- [1,5,4] which meets the requirements and has a sum of 10.
//- [5,4,2] which meets the requirements and has a sum of 11.
//- [4,2,9] which meets the requirements and has a sum of 15.
//- [2,9,9] which does not meet the requirements because the element 9 is 
//repeated.
//- [9,9,9] which does not meet the requirements because the element 9 is 
//repeated.
//We return 15 because it is the maximum subarray sum of all the subarrays that 
//meet the conditions
// 
//
// Example 2: 
//
// 
//Input: nums = [4,4,4], k = 3
//Output: 0
//Explanation: The subarrays of nums with length 3 are:
//- [4,4,4] which does not meet the requirements because the element 4 is 
//repeated.
//We return 0 because no subarrays meet the conditions.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 👍 50 👎 0

package problems.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;2461
 * <p>
 * Name：Maximum Sum of Distinct Subarrays With Length K
 *
 * @author Yuri
 * @since 2024-04-18 18:23:41
 */

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        Solution solution = new MaximumSumOfDistinctSubarraysWithLengthK().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            Set<Integer> hash = new HashSet<>();
            int n = nums.length;
            int l = 0;
            long cnt = 0;
            long max = 0;
            for (int r = 0; r < n; r++) {
                while (hash.contains(nums[r])) {
                    cnt -= nums[l];
                    hash.remove(nums[l++]);
                }
                cnt += nums[r];
                hash.add(nums[r]);
                if (r - l >= k) {
                    cnt -= nums[l];
                    hash.remove(nums[l++]);
                }
                if (r - l == k - 1) max = Math.max(max, cnt);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}