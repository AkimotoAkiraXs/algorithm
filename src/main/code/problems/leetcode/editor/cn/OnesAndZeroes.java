package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;474
 * <p>
 * Name：一和零
 * </p>
 * 三维01背包，只是多一个维度多一层循环，没有其他区别
 *
 * @author Yuri
 * @since 2023-03-04 08:22:16
 */

public class OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new OnesAndZeroes().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] nums = new int[m + 1][n + 1];
//            nums[0][0] = 0;
            for (String str : strs) {
                int zero = (int) str.chars().filter(o -> o == '0').count();
                int one = (int) str.chars().filter(o -> o == '1').count();
                for (int i = m; i >= zero; i--) {
                    for (int j = n; j >= one; j--) {
                        nums[i][j] = Math.max(nums[i][j], nums[i - zero][j - one] + 1);
                    }
                }
            }
            return nums[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
