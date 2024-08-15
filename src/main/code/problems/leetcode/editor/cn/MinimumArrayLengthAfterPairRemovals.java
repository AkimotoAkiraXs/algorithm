// Given an integer array num sorted in non-decreasing order.
//
// You can perform the following operation any number of times: 
//
// 
// Choose two indices, i and j, where nums[i] < nums[j]. 
// Then, remove the elements at indices i and j from nums. The remaining 
// elements retain their original order, and the array is re-indexed.
// 
//
// Return the minimum length of nums after applying the operation zero or more 
// times.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,4] 
// 
//
// Output: 0 
//
// Explanation: 
//
// 
//
// Example 2: 
//
// 
// Input: nums = [1,1,2,2,3,3] 
// 
//
// Output: 0 
//
// Explanation: 
//
// 
//
// Example 3: 
//
// 
// Input: nums = [1000000000,1000000000] 
// 
//
// Output: 2 
//
// Explanation: 
//
// Since both numbers are equal, they cannot be removed. 
//
// Example 4: 
//
// 
// Input: nums = [2,3,4,4,4] 
// 
//
// Output: 1 
//
// Explanation: 
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// nums is sorted in non-decreasing order. 
// 
//
// 👍 24 👎 0

package problems.leetcode.editor.cn;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;2856
 * <p>
 * Name：Minimum Array Length After Pair Removals
 *
 * @author Yuri
 * @since 2024-08-15 14:54:42
 */

public class MinimumArrayLengthAfterPairRemovals {

    public static void main(String[] args) {
        Solution solution = new MinimumArrayLengthAfterPairRemovals().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分，从贪心来看只有maxCount>num.size/2结果才可能不是0（偶数）也不是1（奇数）。
         * 又因为数组有序，所以如果maxCount>num.size/2则中间位置一定是maxCount
         */
        public int minLengthAfterRemovals(List<Integer> nums) {
            int n = nums.size();
            Integer mid = nums.get(n / 2);
            int maxCount = dichotomy(nums, mid + 1) - dichotomy(nums, mid);
            return Math.max(maxCount * 2 - n, n % 2);
        }

        private int dichotomy(List<Integer> nums, int t) {
            int l = 0, r = nums.size();
            while (l < r) {
                int mid = l + r >> 1;
                if (nums.get(mid) < t) l = mid + 1;
                else r = mid;
            }
            return l;
        }

        // 暴力
        public int minLengthAfterRemovals_bf(List<Integer> nums) {
            Map<Integer, Long> count = nums.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
            int max = Math.toIntExact(count.values().stream().max(Long::compare).get());
            return Math.max(2 * max - nums.size(), nums.size() % 2);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}