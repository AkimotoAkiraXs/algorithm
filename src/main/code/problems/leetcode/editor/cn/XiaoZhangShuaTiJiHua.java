// English description is not available for the problem. Please switch to
// Chinese.
// 👍 110 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;LCP 12
 * <p>
 * Name：小张刷题计划
 *
 * @author Yuri
 * @since 2024-09-12 15:24:46
 */

public class XiaoZhangShuaTiJiHua {

    public static void main(String[] args) {
        Solution solution = new XiaoZhangShuaTiJiHua().new Solution();
        solution.minTime(new int[]{1, 2, 3, 3}, 2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minTime(int[] time, int m) {
            int l = 0, r = Arrays.stream(time).sum();
            while (l <= r) {
                int mid = (r - l >> 1) + l;
                int consume = mid, large = 0, d = 1;
                boolean aid = true;
                int i = 0; // 循环遍历问题
                while (i < time.length && d <= m) {
                    if (consume - time[i] >= 0) {
                        consume -= time[i];
                        large = Math.max(large, time[i]);
                        i++;
                    } else if (aid) {
                        aid = false;
                        if (large > time[i]) consume += large - time[i];
                        i++;
                    } else {
                        d++;
                        aid = true;
                        large = 0;
                        consume = mid;
                    }
                }
                if (d <= m) r = mid - 1;
                else l = mid + 1;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}