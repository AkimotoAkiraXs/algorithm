// Given a square matrix mat, return the sum of the matrix diagonals.
//
// Only include the sum of all the elements on the primary diagonal and all the 
// elements on the secondary diagonal that are not part of the primary diagonal.
//
// 
// Example 1: 
// 
// 
// Input: mat = [[1,2,3],
//              [4,5,6],
//              [7,8,9]]
// Output: 25
// Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
// Notice that element mat[1][1] = 5 is counted only once.
// 
//
// Example 2: 
//
// 
// Input: mat = [[1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1]]
// Output: 8
// 
//
// Example 3: 
//
// 
// Input: mat = [[5]]
// Output: 5
// 
//
// 
// Constraints: 
//
// 
// n == mat.length == mat[i].length 
// 1 <= n <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// 👍 106 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1572
 * <p>
 * Name：Matrix Diagonal Sum
 *
 * @author Yuri
 * @since 2023-08-11 18:09:28
 */


public class MatrixDiagonalSum {
    public static void main(String[] args) {
        Solution solution = new MatrixDiagonalSum().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int diagonalSum(int[][] mat) {
            int n = mat.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += mat[i][i];
                ans += mat[n - i - 1][i];
            }
            if ((n & 1) == 1) ans -= mat[n / 2][n / 2];
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
