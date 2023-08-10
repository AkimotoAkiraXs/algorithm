// Given an n x n integer matrix grid, return the minimum sum of a falling path
// with non-zero shifts.
//
// A falling path with non-zero shifts is a choice of exactly one element from 
// each row of grid such that no two elements chosen in adjacent rows are in the
// same column.
//
// 
// Example 1: 
// 
// 
// Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
// Output: 13
// Explanation:
// The possible falling paths are:
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
// The falling path with the smallest sum is [1,5,7], so the answer is 13.
// 
//
// Example 2: 
//
// 
// Input: grid = [[7]]
// Output: 7
// 
//
// 
// Constraints: 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// 👍 158 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1289
 * <p>
 * Name：Minimum Falling Path Sum II
 *
 * @author Yuri
 * @since 2023-08-10 19:47:31
 */


public class MinimumFallingPathSumIi {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSumIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // O(n^2) 记录上一行第一大、第二大的数和第一大的数的坐标，如果在遍历当前行的时候遇到坐标相同就加上第二大的数。
        // 注意更新第一大的数前要更新第二大的数
        public int minFallingPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int firstMin, secondMin, firstIndex;
            firstMin = secondMin = 0;
            firstIndex = -1;


            for (int i = 0; i < m; i++) {
                int curFirstMin, curSecondMin, curFirstIndex = -1;
                curFirstMin = curSecondMin = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    int num;
                    if (j == firstIndex) num = secondMin + grid[i][j];
                    else num = firstMin + grid[i][j];
                    if (num < curFirstMin) {
                        curSecondMin = curFirstMin;
                        curFirstMin = num;
                        curFirstIndex = j;
                    } else if (num < curSecondMin) {
                        curSecondMin = num;
                    }
                }
                firstMin = curFirstMin;
                secondMin = curSecondMin;
                firstIndex = curFirstIndex;
            }
            return firstMin;
        }


        // 暴力Dp
        public int minFallingPathSum_bf(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];

            System.arraycopy(grid[0], 0, dp[0], 0, n);
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < n; k++) {
                        if (k == j) continue;
                        min = Math.min(min, dp[i - 1][k] + grid[i][j]);
                    }
                    dp[i][j] = min;
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) res = Math.min(res, dp[m - 1][i]);
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
