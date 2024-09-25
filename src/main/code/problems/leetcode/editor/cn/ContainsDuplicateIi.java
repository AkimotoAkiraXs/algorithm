// Given an integer array nums and an integer k, return true if there are two
// distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <
//= k. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,1], k = 3
// Output: true
// 
//
// Example 2: 
//
// 
// Input: nums = [1,0,1,1], k = 1
// Output: true
// 
//
// Example 3: 
//
// 
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// 👍 727 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Id：&emsp;&emsp;219
 * <p>
 * Name：Contains Duplicate II
 *
 * @author Yuri
 * @since 2024-09-25 16:32:29
 */

public class ContainsDuplicateIi {

    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> hash = new HashSet<>();
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (i - j > k) hash.remove(nums[j++]);
                if (!hash.add(nums[i])) return true;
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}