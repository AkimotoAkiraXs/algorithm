// You are given an array nums consisting of positive integers.
//
// We call a subarray of an array complete if the following condition is 
// satisfied:
//
// 
// The number of distinct elements in the subarray is equal to the number of 
// distinct elements in the whole array.
// 
//
// Return the number of complete subarrays. 
//
// A subarray is a contiguous non-empty part of an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,3,1,2,2]
// Output: 4
// Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2],
// [3,1,2] and [3,1,2,2].
// 
//
// Example 2: 
//
// 
// Input: nums = [5,5,5,5]
// Output: 10
// Explanation: The array consists only of the integer 5, so any subarray is
// complete. The number of subarrays that we can choose is 10.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2000 
// 
//
// 👍 14 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;2799
 * <p>
 * Name：Count Complete Subarrays in an Array
 *
 * @author Yuri
 * @since 2023-08-09 11:11:43
 */


public class CountCompleteSubarraysInAnArray {
    public static void main(String[] args) {
        Solution solution = new CountCompleteSubarraysInAnArray().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 滑动窗口O(n)
        public int countCompleteSubarrays(int[] nums) {
            int dis = (int) Arrays.stream(nums).distinct().count();
            Map<Integer, Integer> hash = new HashMap<>();
            int r = 0, ans = 0;
            for (int l = 0; l < nums.length; l++) {
                int num = nums[l];
                hash.merge(num, 1, Integer::sum);
                if (hash.size() == dis) {
                    while (r < l && hash.get(nums[r]) != 1) {
                        hash.merge(nums[r], -1, Integer::sum);
                        r++;
                    }
                    ans += r + 1;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
