package problems.leetcode.editor.cn;

import java.util.TreeMap;

/**
 * Id：&emsp;&emsp;2762 <br/>
 * Name：Continuous Subarrays <br/>
 *
 * @author Yuri
 * @since 2023-07-03 22:44:52
 */

public class ContinuousSubarrays {
    public static void main(String[] args) {
        Solution solution = new ContinuousSubarrays().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针（滑动窗口）+哈希表（TreeMap）
         * <p>
         * 思路不难的滑动窗口问题，竞赛时也想到了思路，但是不知道如何记录最大值、最小值。
         * 此处运用了TreeMap，因为有个>2的限制条件，所以Map中最多4个数，暴力获取最大最小也是可行的。
         * 此处直接调用firstKey()、lastKey()。
         * <p>
         * 此题思路不难，难度在代码编排上：一般来说滑动右指针，变动左指针不用担心越界问题，所以比较便捷。
         */
        public long continuousSubarrays(int[] nums) {
            int n = nums.length;
            TreeMap<Integer, Integer> cnt = new TreeMap<>();
            long res = 0;
            for (int l = 0, r = 0; r < n; r++) {
                cnt.merge(nums[r], 1, Integer::sum);
                while (cnt.lastKey() - cnt.firstKey() > 2) {
                    cnt.compute(nums[l++], (k, v) -> {
                        if (v == 1) return null;
                        return --v;
                    });
                }
                res += r - l + 1;
            }
            return res;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}
