package template;

import problems.leetcode.editor.cn.NumberOfWaysOfCuttingAPizza;

/**
 * 前缀和相关模板
 *
 * @author Yuri
 * @since 2023/8/18 18:20
 */


public class PrefixSumTemplate {

    /**
     * 二维前缀和模板
     *
     * @see NumberOfWaysOfCuttingAPizza Lc1444 切披萨的方案数
     */
    class PrefixSum_2D {

        private final int[][] sum;

        public PrefixSum_2D(int[][] num) {
            int m = num.length, n = num[0].length;
            sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + num[i - 1][j - 1];
        }

        public int query(int row1, int col1, int row2, int col2) {
            return sum[row2][col2] - sum[row2][col1] - sum[row1][col2] + sum[row1][col1];
        }
    }
}
