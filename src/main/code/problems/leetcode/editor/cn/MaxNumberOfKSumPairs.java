// You are given an integer array nums and an integer k.
//
// In one operation, you can pick two numbers from the array whose sum equals k 
// and remove them from the array.
//
// Return the maximum number of operations you can perform on the array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,4], k = 5
// Output: 2
// Explanation: Starting with nums = [1,2,3,4]:
//- Remove numbers 1 and 4, then nums = [2,3]
//- Remove numbers 2 and 3, then nums = []
// There are no more pairs that sum up to 5, hence a total of 2 operations.
//
// Example 2: 
//
// 
// Input: nums = [3,1,3,4,3], k = 6
// Output: 1
// Explanation: Starting with nums = [3,1,3,4,3]:
//- Remove the first two 3's, then nums = [1,4,3]
// There are no more pairs that sum up to 6, hence a total of 1 operation.
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 
//
// 👍 85 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import problems.leetcode.editor.cn.DesignHashmap.MyHashMap.Pair;

/**
 * Id：&emsp;&emsp;1679
 * <p>
 * Name：Max Number of K-Sum Pairs
 *
 * @author Yuri
 * @since 2024-09-26 10:09:04
 */

public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        Solution solution = new MaxNumberOfKSumPairs().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxOperations(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int num : nums) {
                if (num >= k) continue;
                int key = k - num;
                Integer val = map.get(key);
                if (val != null) {
                    if (val > 1) map.put(key, val - 1);
                    else map.remove(key);
                    ans++;
                } else map.merge(num, 1, Integer::sum);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}