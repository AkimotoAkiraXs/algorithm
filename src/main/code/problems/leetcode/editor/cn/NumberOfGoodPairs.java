// Given an array of integers nums, return the number of good pairs.
//
// A pair (i, j) is called good if nums[i] == nums[j] and i < j. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,1,1,3]
// Output: 4
// Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
// 
//
// Example 2: 
//
// 
// Input: nums = [1,1,1,1]
// Output: 6
// Explanation: Each pair in the array are good.
// 
//
// Example 3: 
//
// 
// Input: nums = [1,2,3]
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
//
// 👍 155 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;1512
 * <p>
 * Name：Number of Good Pairs
 *
 * @author Yuri
 * @since 2024-09-25 16:19:10
 */

public class NumberOfGoodPairs {

    public static void main(String[] args) {
        Solution solution = new NumberOfGoodPairs().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numIdenticalPairs(int[] nums) {
            Map<Integer, Integer> hash = new HashMap<>();
            int ans = 0;
            for (int num : nums) {
                if (!hash.containsKey(num)) hash.put(num, 1);
                else ans += hash.merge(num, 1, Integer::sum) - 1;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}