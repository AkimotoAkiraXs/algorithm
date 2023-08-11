package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2778 <br/>
 * Name：Sum of Squares of Special Elements  <br/>
 *
 * @author Yuri
 * @since 2023-07-18 21:55:53
 */

public class SumOfSquaresOfSpecialElements {
    public static void main(String[] args) {
        Solution solution = new SumOfSquaresOfSpecialElements().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfSquares(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++)
                if (nums.length % (i + 1) == 0) ans += nums[i] * nums[i];
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
