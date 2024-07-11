// You are given a 0-indexed integer array nums. In one operation, you can:
//
// 
// Choose two different indices i and j such that 0 <= i, j < nums.length. 
// Choose a non-negative integer k such that the kᵗʰ bit (0-indexed) in the 
// binary representation of nums[i] and nums[j] is 1.
// Subtract 2ᵏ from nums[i] and nums[j]. 
// 
//
// A subarray is beautiful if it is possible to make all of its elements equal 
// to 0 after applying the above operation any number of times.
//
// Return the number of beautiful subarrays in the array nums. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [4,3,1,2,4]
// Output: 2
// Explanation: There are 2 beautiful subarrays in nums: [4,3,1,2,4] and [4,3,1,2
//,4].
//- We can make all elements in the subarray [3,1,2] equal to 0 in the 
// following way:
//  - Choose [3, 1, 2] and k = 1. Subtract 2¹ from both numbers. The subarray 
// becomes [1, 1, 0].
//  - Choose [1, 1, 0] and k = 0. Subtract 2⁰ from both numbers. The subarray 
// becomes [0, 0, 0].
//- We can make all elements in the subarray [4,3,1,2,4] equal to 0 in the 
// following way:
//  - Choose [4, 3, 1, 2, 4] and k = 2. Subtract 2² from both numbers. The 
// subarray becomes [0, 3, 1, 2, 0].
//  - Choose [0, 3, 1, 2, 0] and k = 0. Subtract 2⁰ from both numbers. The 
// subarray becomes [0, 2, 0, 2, 0].
//  - Choose [0, 2, 0, 2, 0] and k = 1. Subtract 2¹ from both numbers. The 
// subarray becomes [0, 0, 0, 0, 0].
// 
//
// Example 2: 
//
// 
// Input: nums = [1,10,4]
// Output: 0
// Explanation: There are no beautiful subarrays in nums.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// 
//
// 👍 43 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;2588
 * <p>
 * Name：Count the Number of Beautiful Subarrays
 *
 * @author Yuri
 * @since 2024-07-10 18:12:27
 */

public class CountTheNumberOfBeautifulSubarrays {

    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfBeautifulSubarrays().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long beautifulSubarrays(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            long ans = 0;
            int pre = 0;
            for (int num : nums) {
                count.merge(pre, 1, Integer::sum);
                pre ^= num;
                if (count.containsKey(pre)) {
                    ans += count.get(pre);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}