// English description is not available for the problem. Please switch to
// Chinese.
// 👍 60 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;LCP 08
 * <p>
 * Name：剧情触发时间
 *
 * @author Yuri
 * @since 2024-08-19 16:12:47
 */

public class JuQingHongFaShiJian {

    public static void main(String[] args) {
        Solution solution = new JuQingHongFaShiJian().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] getTriggerTime(int[][] increase, int[][] requirements) {
            int dn = increase.length, rn = requirements.length;
            int[] a = new int[dn + 1], b = new int[dn + 1], c = new int[dn + 1];
            for (int i = 0; i < dn; i++) {
                a[i + 1] = a[i] + increase[i][0];
                b[i + 1] = b[i] + increase[i][1];
                c[i + 1] = c[i] + increase[i][2];
            }
            int[] ans = new int[rn];
            for (int i = 0; i < rn; i++) {
                int max = 0;
                max = Math.max(max, dichotomy(a, requirements[i][0]));
                max = Math.max(max, dichotomy(b, requirements[i][1]));
                max = Math.max(max, dichotomy(c, requirements[i][2]));
                if (max == a.length) max = -1;
                ans[i] = max;
            }
            return ans;
        }

        private int dichotomy(int[] nums, int t) {
            int l = 0, r = nums.length;
            while (l < r) {
                int m = l + r >> 1;
                if (nums[m] < t) l = m + 1;
                else r = m;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}