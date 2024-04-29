// You are given an array of positive integers nums and want to erase a subarray
// containing unique elements. The score you get by erasing the subarray is equal
// to the sum of its elements.
//
// Return the maximum score you can get by erasing exactly one subarray. 
//
// An array b is called to be a subarray of a if it forms a contiguous 
// subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
//
// 
// Example 1: 
//
// 
// Input: nums = [4,2,4,5,6]
// Output: 17
// Explanation: The optimal subarray here is [2,4,5,6].
// 
//
// Example 2: 
//
// 
// Input: nums = [5,2,1,2,5,2,1,2,5]
// Output: 8
// Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 👍 80 👎 0

package problems.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Id：&emsp;&emsp;1695
 * <p>
 * Name：Maximum Erasure Value
 *
 * @author Yuri
 * @since 2024-04-29 18:15:05
 */

public class MaximumErasureValue {

    public static void main(String[] args) {
        Solution solution = new MaximumErasureValue().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumUniqueSubarray(int[] nums) {
            int max = 0, l = 0, cnt = 0;
            Set<Integer> hash = new HashSet<>();
            for (int num : nums) {
                cnt += num;
                if (!hash.add(num)) {
                    while (nums[l] != num) {
                        cnt -= nums[l];
                        hash.remove(nums[l]);
                        l++;
                    }
                    cnt -= nums[l++];
                }
                max = Math.max(max, cnt);
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}