package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1137 <br/>
 * Name：N-th Tribonacci Number <br/>
 *
 * @author Yuri
 * @since 2023-05-17 23:25:18
 */

public class NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 矩阵快速幂模板题
        /*
         *       [1*f(2), 0*f(1), 0*f(0)]   [1, 0, 0]   [f(2)]   [1, 0, 0]   [1]
         * ans = [0*f(2), 1*f(1), 0*f(0)] = [0, 1, 0] * [f(1)] = [0, 1, 0] * [1]
         *       [0*f(2), 0*f(1), 1*f(0)]   [0, 0, 1]   [f(0)]   [0, 0, 1]   [0]
         *
         * ∴ f(n) = res[0][0]*1 + res[0][1]*1 +res[0][2]*0 = res[0][0] + res[0][1];
         * */
        int[][] mul(int[][] a, int[][] b) {
            int N = 3;
            int[][] c = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
                }
            }
            return c;
        }

        public int tribonacci(int n) {
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;
            int[][] ans = new int[][]{
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}
            };
            int[][] mat = new int[][]{
                    {1, 1, 1},
                    {1, 0, 0},
                    {0, 1, 0}
            };
            int k = n - 2;
            while (k != 0) {
                if ((k & 1) != 0) ans = mul(ans, mat);
                mat = mul(mat, mat);
                k >>= 1;
            }
            return ans[0][0] + ans[0][1];
        }

/*
        // Dp
        public int tribonacci(int n) {
            int[] dp = new int[4];
            dp[0] = 0;
            if (n >= 1) dp[1] = 1;
            if (n >= 2) dp[2] = 1;
            for (int i = 3; i <= n; i++) dp[i % 4] = dp[(i - 3) % 4] + dp[(i - 2) % 4] + dp[(i - 1) % 4];
            return dp[n % 4];
        }
*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
