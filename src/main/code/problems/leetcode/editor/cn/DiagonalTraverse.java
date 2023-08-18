//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 矩阵 模拟 👍 391 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;498
 * <p>
 * Name：对角线遍历
 *
 * @author Yuri
 * @since 2022-08-22 17:42:06
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        solution.findDiagonalOrder(new int[][]{{2, 5}, {8, 4}, {0, -1}});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 一共有 m + n - 1条对角线，相邻的对角线的遍历方向不同，当前遍历方向为从左下到右上，则紧挨着的下一条对角线遍历方向为从右上到左下；
         * <p>
         * 设对角线从上到下的编号为 i ∈ [0, m + n − 2]：
         * <p>
         * 当 i 为偶数时，则第 i 条对角线的走向是从下往上遍历；
         * 当 i 为奇数时，则第 i 条对角线的走向是从上往下遍历；
         * 当第 i 条对角线从下往上遍历时，每次行索引减 1，列索引加 1，直到矩阵的边缘为止：
         * <p>
         * 当 i < m 时，则此时对角线遍历的起点位置为 (i,0)；
         * 当 i ≥ m 时，则此时对角线遍历的起点位置为 (m - 1, i - m + 1)；
         * 当第 ii 条对角线从上往下遍历时，每次行索引加 1，列索引减 1，直到矩阵的边缘为止：
         * <p>
         * 当 i < n 时，则此时对角线遍历的起点位置为 (0, i)；
         * 当 i ≥ n 时，则此时对角线遍历的起点位置为 (i - n + 1, n - 1)；
         */
        public int[] findDiagonalOrder(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;

            int[] ans = new int[n * m];
            int row = 0, column = 0;
            boolean dir = true;
            int step = 0;
            while (step < n * m) {
                ans[step++] = mat[row][column];
                if (dir) {
                    if (row == 0) {
                        if (column == m - 1) {
                            row++;
                        } else {
                            column++;
                        }
                        dir = false;
                    } else if (column == m - 1) {
                        row++;
                        dir = false;
                    } else {
                        row--;
                        column++;
                    }
                } else {
                    if (column == 0) {
                        if (row == n - 1) {
                            column++;
                        } else {
                            row++;
                        }
                        dir = true;
                    } else if (row == n - 1) {
                        column++;
                        dir = true;
                    } else {
                        row++;
                        column--;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}