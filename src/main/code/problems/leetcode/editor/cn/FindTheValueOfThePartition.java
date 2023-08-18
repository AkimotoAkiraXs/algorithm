package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2740 <br/>
 * Name：Find the Value of the Partition <br/>
 * <p>
 * 单周赛350 Q2
 *
 * @author Yuri
 * @since 2023-06-20 21:51:02
 */

public class FindTheValueOfThePartition {
    public static void main(String[] args) {
        Solution solution = new FindTheValueOfThePartition().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题意理解题
        public int findValueOfPartition(int[] nums) {
            Arrays.sort(nums);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++)
                min = Math.min(nums[i] - nums[i - 1], min);
            return min;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
