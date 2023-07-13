// Given an n x n array of integers matrix, return the minimum sum of any
// falling path through matrix.
//
// A falling path starts at any element in the first row and chooses the 
// element in the next row that is either directly below or diagonally left/right.
// Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
// row + 1, col), or (row + 1, col + 1).
//
// 
// Example 1: 
// 
// 
// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.
// 
//
// Example 2: 
// 
// 
// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is shown.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// 👍 259 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;931
 * <p>
 * Name：Minimum Falling Path Sum
 *
 * @author Yuri
 * @since 2023-07-13 10:47:38
 */


public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
        solution.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n + 1][n + 2];
            System.arraycopy(matrix[0], 0, dp[1], 1, n);
            // 从第一层开始单纯是为了给两端赋值，懒得写两遍
            for (int i = 1; i <= n; i++) {
                dp[i][0] = dp[i][n + 1] = Integer.MAX_VALUE;
                for (int j = 1; j <= n; j++)
                    dp[i][j] = Math.min(dp[i - 1][j + 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + matrix[i - 1][j - 1];
            }
            return Arrays.stream(dp[n]).min().orElse(0);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
