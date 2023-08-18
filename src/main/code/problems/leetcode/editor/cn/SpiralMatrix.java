//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1181 👎 0


package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;54
 * <p>
 * Name：螺旋矩阵
 *
 * @author Yuri
 * @since 2022-08-22 11:11:18
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int n = matrix.length;
            int m = matrix[0].length;
            List<Integer> ans = new ArrayList<>();
            int row = 0, cloumn = 0;
            int k = 0;

            while (ans.size() < n * m) {
                ans.add(matrix[row][cloumn]);
                if (row + dir[k % 4][1] == n - k / 4
                        || row + dir[k % 4][1] == (k + 1) / 4 - 1
                        || cloumn + dir[k % 4][0] == m - k / 4
                        || cloumn + dir[k % 4][0] == k / 4 - 1) {
                    k++;
                }
                cloumn += dir[k % 4][0];
                row += dir[k % 4][1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}