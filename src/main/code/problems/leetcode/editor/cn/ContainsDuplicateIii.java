// You are given an integer array nums and two integers indexDiff and valueDiff.
//
//
// Find a pair of indices (i, j) such that: 
//
// 
// i != j, 
// abs(i - j) <= indexDiff. 
// abs(nums[i] - nums[j]) <= valueDiff, and 
// 
//
// Return true if such pair exists or false otherwise. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
// Output: true
// Explanation: We can choose (i, j) = (0, 3).
// We satisfy the three conditions:
// i != j --> 0 != 3
// abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
// abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
// 
//
// Example 2: 
//
// 
// Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
// Output: false
// Explanation: After trying all the possible pairs (i, j), we cannot satisfy
// the three conditions, so we return false.
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 1 <= indexDiff <= nums.length 
// 0 <= valueDiff <= 10⁹ 
// 
//
// 👍 739 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Id：&emsp;&emsp;220
 * <p>
 * Name：Contains Duplicate III
 *
 * @author Yuri
 * @since 2024-09-25 17:17:32
 */

public class ContainsDuplicateIii {

    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            TreeSet<Integer> hash = new TreeSet<>();
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (i - j > indexDiff) hash.remove(nums[j++]);
                Integer floor = hash.floor(nums[i]);
                if (floor != null && nums[i] - floor <= valueDiff) return true;
                Integer ceiling = hash.ceiling(nums[i]);
                if (ceiling != null && ceiling - nums[i] <= valueDiff) return true;
                hash.add(nums[i]);
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}