//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 793 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;59
 * <p>
 * Name：螺旋矩阵 II
 *
 * @author Yuri
 * @since 2022-08-22 15:37:01
 */
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(3);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int step = 1;
            int[][] ans = new int[n][n];
            int top = 0, bottom = n - 1, left = 0, right = n - 1;
            int row = 0, column = 0;
            while (step <= n * n) {
                for (column = left; column <= right; ++column) {
                    ans[row][column] = step++;
                }
                top++;
                column--;
                for (row = top; row <= bottom; ++row) {
                    ans[row][column] = step++;
                }
                right--;
                row--;
                for (column = right; column >= left; --column) {
                    ans[row][column] = step++;
                }
                bottom--;
                column++;
                for (row = bottom; row >= top; --row) {
                    ans[row][column] = step++;
                }
                left++;
                row++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}