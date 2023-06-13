// You are given a 0-indexed array of positive integers nums. Find the number of
// triplets (i, j, k) that meet the following conditions:
//
// 
// 0 <= i < j < k < nums.length 
// nums[i], nums[j], and nums[k] are pairwise distinct. 
// 
// In other words, nums[i] != nums[j], nums[i] != nums[k], and nums[j] != nums[
// k].
// 
// 
//
// Return the number of triplets that meet the conditions. 
//
// 
// Example 1: 
//
// 
// Input: nums = [4,4,2,4,3]
// Output: 3
// Explanation: The following triplets meet the conditions:
//- (0, 2, 4) because 4 != 2 != 3
//- (1, 2, 4) because 4 != 2 != 3
//- (2, 3, 4) because 2 != 4 != 3
// Since there are 3 triplets, we return 3.
// Note that (2, 0, 4) is not a valid triplet because 2 > 0.
// 
//
// Example 2: 
//
// 
// Input: nums = [1,1,1,1,1]
// Output: 0
// Explanation: No triplets meet the conditions so we return 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 100 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 👍 67 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;2475
 * <p>
 * Name：Number of Unequal Triplets in Array
 *
 * @author Yuri
 * @since 2023-06-13 17:33:56
 */


public class NumberOfUnequalTripletsInArray {
    public static void main(String[] args) {
        Solution solution = new NumberOfUnequalTripletsInArray().new Solution();
        int i = solution.unequalTriplets(new int[]{4, 4, 2, 4, 3, 5, 5});
        System.out.println(i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 哈希表
        public int unequalTriplets(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int x : nums) count.merge(x, 1, Integer::sum); // 统计每个数的数量
            int res = 0, n = nums.length, l = 0;
            for (Integer num : count.values()) {
                res += l * num * (n - l - num); // l = 左边可选数数量，num = 当前数数量，(n - l - num) = 右边可选数数量
                l += num;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
