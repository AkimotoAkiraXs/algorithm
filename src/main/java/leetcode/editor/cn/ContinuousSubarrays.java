package leetcode.editor.cn;

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
            var map = new TreeMap<Integer, Integer>();
            long ans = 0;
            var l = 0;
            var r = 0;
            for (; r < nums.length; r++) {
                map.merge(nums[r], 1, Integer::sum);
                while (Math.abs(map.firstKey() - map.lastKey()) > 2) { // 当l=r时，first=last不会满足条件，所以不担心l>r
                    if (map.get(nums[l]) == 1) map.remove(nums[l]);
                    else map.merge(nums[l], -1, Integer::sum);
                    l++;
                }
                // 右指针滑动固定加ans，而不是左指针变动加ans，避免循环弹出时还有最后那部分子数组未算到
                // 每次新加子数组数是多少？考虑包含nums[r]的子数组有几个！
                ans += r - l + 1;
            }
            return ans;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}
