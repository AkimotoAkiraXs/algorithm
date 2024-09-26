// You are given a 0-indexed array nums consisting of positive integers. You can
// choose two indices i and j, such that i != j, and the sum of digits of the
// number nums[i] is equal to that of nums[j].
//
// Return the maximum value of nums[i] + nums[j] that you can obtain over all 
// possible indices i and j that satisfy the conditions.
//
// 
// Example 1: 
//
// 
// Input: nums = [18,43,36,13,7]
// Output: 54
// Explanation: The pairs (i, j) that satisfy the conditions are:
//- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 
// 36 = 54.
//- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 
// 7 = 50.
// So the maximum sum that we can obtain is 54.
// 
//
// Example 2: 
//
// 
// Input: nums = [10,12,19,14]
// Output: -1
// Explanation: There are no two numbers that satisfy the conditions, so we
// return -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 79 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;2342
 * <p>
 * Name：Max Sum of a Pair With Equal Sum of Digits
 *
 * @author Yuri
 * @since 2024-09-26 10:00:54
 */

public class MaxSumOfAPairWithEqualSumOfDigits {

    public static void main(String[] args) {
        Solution solution = new MaxSumOfAPairWithEqualSumOfDigits().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumSum(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = -1;
            for (int num : nums) {
                int key = bitSum(num);
                if (map.containsKey(key)) {
                    ans = Math.max(ans, num + map.get(key));
                    map.put(key, Math.max(num, map.get(key)));
                } else map.put(key, num);
            }
            return ans;
        }

        private int bitSum(int num) {
            return String.valueOf(num).chars().map(i -> i - '0').sum();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}