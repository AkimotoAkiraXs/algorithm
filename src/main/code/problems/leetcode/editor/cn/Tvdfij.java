// English description is not available for the problem. Please switch to
// Chinese.
//
// 👍 77 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;LCR 012
 * <p>
 * Name：寻找数组的中心下标
 *
 * @author Yuri
 * @see FindPivotIndex Lc724
 * @see FindTheMiddleIndexInArray Lc1991
 * @since 2025-03-09 16:10:01
 */

public class Tvdfij {
    public static void main(String[] args) {
        Solution solution = new Tvdfij().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int tot = 0;
            for (int i = 0; i < nums.length; i++) {
                if (tot == sum - tot - nums[i]) return i;
                tot += nums[i];
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}