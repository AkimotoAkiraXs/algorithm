// Given an integer array nums and an integer k, return the number of good
// subarrays of nums.
//
// A subarray arr is good if it there are at least k pairs of indices (i, j) 
// such that i < j and arr[i] == arr[j].
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,1,1,1,1], k = 10
// Output: 1
// Explanation: The only good subarray is the array nums itself.
// 
//
// Example 2: 
//
// 
// Input: nums = [3,1,4,3,2,2,4], k = 2
// Output: 4
// Explanation: There are 4 different good subarrays:
//- [3,1,4,3,2,2] that has 2 pairs.
//- [3,1,4,3,2,2,4] that has 3 pairs.
//- [1,4,3,2,2,4] that has 2 pairs.
//- [4,3,2,2,4] that has 2 pairs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i], k <= 10⁹ 
// 
//
// 👍 54 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Id：&emsp;&emsp;2537
 * <p>
 * Name：Count the Number of Good Subarrays
 *
 * @author Yuri
 * @since 2024-05-13 14:55:26
 */

public class CountTheNumberOfGoodSubarrays {

    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfGoodSubarrays().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 灵神：逆向思维，维护不满足题意的窗口
         * <p>
         * 右指针遍历数组，左指针每次找到不符合题意的子数组最左边的位置。
         */
        public long countGood_reverse1(int[] nums, int k) {
            var cnt = new HashMap<Integer, Integer>();
            long ans = 0;
            int left = 0, pairs = 0;
            for (int x : nums) {
                pairs += cnt.getOrDefault(x, 0);
                cnt.merge(x, 1, Integer::sum); // 移入右端点
                while (pairs - cnt.get(nums[left]) + 1 >= k)
                    pairs -= cnt.merge(nums[left++], -1, Integer::sum); // 移出左端点
                if (pairs >= k) ans += left + 1;
            }
            return ans;
        }

        // 写法2
        public long countGood_reverse2(int[] nums, int k) {
            var cnt = new HashMap<Integer, Integer>();
            long ans = 0;
            int left = 0, pairs = 0;
            for (int x : nums) {
                pairs += cnt.getOrDefault(x, 0);
                cnt.merge(x, 1, Integer::sum); // 移入右端点
                ans += left; // 以当前位置为右边，从0到left-1为左边的子数组都是满足条件的
                while (pairs >= k) {
                    pairs -= cnt.merge(nums[left++], -1, Integer::sum); // 移出左端点
                    ++ans; // 以当前位置为右边从，left为左边的子数组是满足条件的
                }
            }
            return ans;
        }


        // 正向：滑动窗口
        public long countGood(int[] nums, int k) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            AtomicInteger cnt = new AtomicInteger();
            long res = 0;
            for (int l = 0, r = 0; r < n; r++) {
                map.compute(nums[r], (key, value) -> {
                    if (value == null) return 1;
                    cnt.addAndGet(value);
                    return ++value;
                });
                while (cnt.get() >= k) {
                    res += n - r;
                    map.compute(nums[l++], (key, value) -> {
                        cnt.getAndAdd(-(--value));
                        return value;
                    });
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}