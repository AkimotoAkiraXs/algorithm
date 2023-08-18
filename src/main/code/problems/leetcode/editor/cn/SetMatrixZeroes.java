//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 765 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;73
 * <p>
 * Name：矩阵置零
 *
 * @author Yuri
 * @since 2022-08-25 11:41:03
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 正确做法是用枚举标记第一行和第一例是否置零，然后用第一行和第一例的数作为标记该行该列是否置零
        // 偷鸡做法，用一个测试用例中不存在的数作为标记
        public void setZeroes(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        for (int k = 0; k < n; k++) {
                            if (matrix[k][j] != 0 && matrix[k][j] != Integer.MIN_VALUE + 1293993) matrix[k][j] = Integer.MIN_VALUE + 1293993;
                        }
                        for (int k = 0; k < m; k++) {
                            if (matrix[i][k] != 0 && matrix[i][k] != Integer.MIN_VALUE + 1293993) matrix[i][k] = Integer.MIN_VALUE + 1293993;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == Integer.MIN_VALUE + 1293993) matrix[i][j] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}