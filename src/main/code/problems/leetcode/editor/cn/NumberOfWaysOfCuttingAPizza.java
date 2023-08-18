// Given a rectangular pizza represented as a rows x cols matrix containing the
// following characters: 'A' (an apple) and '.' (empty cell) and given the integer
// k. You have to cut the pizza into k pieces using k-1 cuts.
//
// For each cut you choose the direction: vertical or horizontal, then you 
// choose a cut position at the cell boundary and cut the pizza into two pieces. If you
// cut the pizza vertically, give the left part of the pizza to a person. If you
// cut the pizza horizontally, give the upper part of the pizza to a person. Give
// the last piece of pizza to the last person.
//
// Return the number of ways of cutting the pizza such that each piece contains 
// at least one apple. Since the answer can be a huge number, return this modulo 10
//^9 + 7. 
//
// 
// Example 1: 
//
// 
//
// 
// Input: pizza = ["A..","AAA","..."], k = 3
// Output: 3
// Explanation: The figure above shows the three ways to cut the pizza. Note
// that pieces must contain at least one apple.
// 
//
// Example 2: 
//
// 
// Input: pizza = ["A..","AA.","..."], k = 3
// Output: 1
// 
//
// Example 3: 
//
// 
// Input: pizza = ["A..","A..","..."], k = 1
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= rows, cols <= 50 
// rows == pizza.length 
// cols == pizza[i].length 
// 1 <= k <= 10 
// pizza consists of characters 'A' and '.' only. 
// 
//
// 👍 150 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1444
 * <p>
 * Name：Number of Ways of Cutting a Pizza
 *
 * @author Yuri
 * @since 2023-08-17 16:22:15
 */


public class NumberOfWaysOfCuttingAPizza {
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysOfCuttingAPizza().new Solution();

        solution.ways(new String[]{"A..", "AAA", "..."}, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 进阶版Dp，O(kmn)
         * <p>
         * 对于矩形(i,j,m,n)而言，如果最上边第一行没有苹果，则其方案数=矩形(i+1,j,m,n)。
         * 同理，如果最左边第一列没有苹果，其方案数=矩形(i,j+1,m,n)。
         * 如果都有苹果，则表示无论如何切都会有苹果（无论是横切i+1,i+2,...,m-1，还是竖切j+1,j+2,...,n-1），
         * 也就是说(i,j,m,n)方案数是其所有子矩阵方案数之和。
         */
        public int ways(String[] pizza, int k) {
            int mod = (int) 1e9 + 7;
            int m, n;
            m = pizza.length;
            n = pizza[0].length();
            int[][] dp;
            dp = new int[m + 1][n + 1];
            int[][] sum = new int[m + 1][n + 1];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    // 记录后缀和
                    sum[i][j] = sum[i + 1][j] + sum[i][j + 1] - sum[i + 1][j + 1] + (pizza[i].charAt(j) & 1);
                    // 初始化
                    if (sum[i][j] > 0) dp[i][j] = 1;
                }
            }
            for (int z = 1; z < k; z++) {
                int[] cols = new int[n]; // cols中记录j列从下往上累加的和
                for (int i = m - 1; i >= 0; i--) {
                    int row = 0; // row记录i行，从右往左累加的和
                    for (int j = n - 1; j >= 0; j--) {
                        // 先把上一次的结果记录下来
                        int temp = dp[i][j];
                        if (sum[i][j] == sum[i + 1][j]) dp[i][j] = dp[i + 1][j];
                        else if (sum[i][j] == sum[i][j + 1]) dp[i][j] = dp[i][j + 1];
                        else dp[i][j] = (cols[j] + row) % mod;
                        row = (row + temp) % mod;
                        cols[j] = (cols[j] + temp) % mod;
                    }
                }
            }
            return dp[0][0];
        }

        /**
         * 原始dp O(kmn(m+n))，dp[k][i][j]表示切第k刀，左上角(i,j)到右下角(m,n)矩形的方案数。
         * <p>
         * 本题中状态推导式从右下到左上递推，所以顺序遍历m，n时可以直接降维，定义dp = new int[m][n]
         */
        public int ways_origin(String[] pizza, int k) {
            int mod = (int) 1e9 + 7;
            int m, n;
            m = pizza.length;
            n = pizza[0].length();
            int[][][] dp;
            dp = new int[k][m][n]; // 顺序遍历，dp可以直接降维优化空间
            Matrix matrix = new Matrix(pizza); // 获取前缀和
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (matrix.query(i, j, m, n) > 0) dp[0][i][j] = 1; // 初始化，一刀不切有苹果则方案为1
            // 循环遍历kmn，因为是三维，每次取的k-1中的状态，所以mn正反顺序无所谓
            for (int x = 1; x < k; x++) {
                for (int y = 0; y < m; y++) {
                    for (int z = 0; z < n; z++) {
                        long res = 0;
                        // 遍历横切和竖切每种方案（同记忆化dfs）
                        for (int o = y + 1; o < m; o++)
                            // 只需关心切的上方和左方有没有苹果，如果剩下矩形披萨的没有苹果那么其方案数也会为0，加也不影响。
                            if (matrix.query(y, z, o, n) > 0)
                                res = (res + dp[x - 1][o][z]) % mod;
                        for (int o = z + 1; o < n; o++)
                            if (matrix.query(y, z, m, o) > 0)
                                res = (res + dp[x - 1][y][o]) % mod;
                        dp[x][y][z] = (int) res;
                    }
                }
            }
            return dp[k - 1][0][0];
        }
    }

    /**
     * 暴力回溯，记忆化dfs
     * <p>
     * 其实用记忆化搜索来做难点就只有二维前缀和了
     */
    class Solution_memory {
        int m, n;
        int mod = (int) 1e9 + 7;
        int[][][] dp;
        Matrix matrix;

        public int ways(String[] pizza, int k) {
            m = pizza.length;
            n = pizza[0].length();
            matrix = new Matrix(pizza);
            dp = new int[k + 1][m + 1][n + 1];
            for (int i = 0; i <= k; i++)
                for (int j = 0; j <= m; j++)
                    Arrays.fill(dp[i][j], -1);
            return (int) dfs(k, 0, 0);
        }

        private long dfs(int k, int x, int y) {
            if (dp[k][x][y] != -1) return dp[k][x][y];
            if (k == 1) return matrix.query(x, y, m, n) > 0 ? 1L : 0L;
            long res = 0;
            for (int i = x + 1; i < m; i++)
                if (matrix.query(x, y, i, n) > 0)
                    res = (res + dfs(k - 1, i, y)) % mod;
            for (int j = y + 1; j < n; j++)
                if (matrix.query(x, y, m, j) > 0)
                    res = (res + dfs(k - 1, x, j)) % mod;
            dp[k][x][y] = (int) res;
            return res;
        }
    }

    // 二维前缀和模板（'A' 的 ASCII 码最低位为 1，'.' 的 ASCII 码最低位为 0）
    class Matrix {

        private final int[][] sum;

        public Matrix(String[] pizza) {
            int m = pizza.length, n = pizza[0].length();
            sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1]
                            + (pizza[i - 1].charAt(j - 1) & 1);
        }

        public int query(int row1, int col1, int row2, int col2) {
            return sum[row2][col2] - sum[row2][col1] - sum[row1][col2] + sum[row1][col1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
} 
