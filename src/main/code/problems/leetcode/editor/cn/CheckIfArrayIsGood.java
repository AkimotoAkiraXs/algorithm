package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2784 <br/>
 * Name：Check if Array is Good <br/>
 *
 * @author Yuri
 * @since 2023-07-25 23:47:22
 */

public class CheckIfArrayIsGood {
    public static void main(String[] args) {
        Solution solution = new CheckIfArrayIsGood().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isGood(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 1; i < nums.length; i++) if (nums[i - 1] != i) return false;
            return nums[n - 1] == n - 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
