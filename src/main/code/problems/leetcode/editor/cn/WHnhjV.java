//👍 23 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;LCP 50
 * <p>
 * Name：宝石补给
 *
 * @author Yuri
 * @since 2023-09-15 09:39:57
 */

public class WHnhjV {

    public static void main(String[] args) {
        Solution solution = new WHnhjV().new Solution();
        solution.giveGem(new int[]{0, 2, 5, 4},
            new int[][]{{3, 2}, {3, 2}, {1, 3}, {0, 2}, {3, 0}, {3, 1}, {0, 3}, {2, 1}, {3, 0}});

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int giveGem(int[] gem, int[][] operations) {
            for (int[] operation : operations) {
                int give = gem[operation[0]] / 2;
                gem[operation[1]] += give;
                gem[operation[0]] -= give;
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int g : gem) {
                max = Math.max(g, max);
                min = Math.min(g, min);
            }
            return max - min;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}