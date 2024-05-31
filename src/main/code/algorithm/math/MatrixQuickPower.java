package algorithm.math;

import problems.leetcode.editor.cn.ApplyOperationsToMaximizeScore;
import problems.leetcode.editor.cn.NThTribonacciNumber;

/**
 * 矩阵快速幂：矩阵快速幂用于求解一般性问题，通过问题转换为矩阵运算来快速求解答案
 * <p>
 * 具体问题转换为矩阵求解此处不做讨论，需要具体问题具体分析，比较考验线性数学功底（好歹你是满绩点的，别说不会吖o(╥﹏╥)o）
 * <p>
 * 主要用于logn时间复杂度求解n^m次方的场景
 *
 * @author Yuri
 * @see NThTribonacciNumber 矩阵快速幂模板题-Lc1137 第N个泰波那契数
 * @see ApplyOperationsToMaximizeScore Lc2818 操作使得分最大
 * @since 2023/5/22 23:04
 */

public class MatrixQuickPower {

    public static void main(String[] args) {
        // 设有矩阵mat，现在需要求解mat^n
        int[][] mat = {
                {1, 0, 1},
                {1, 0, 0},
                {0, 0, 1}
        };
        // ans矩阵是根据题意推出来的，最后答案f(n)一般是由ans中的一部分通过矩阵相乘得到
        int[][] ans = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        int n = 189999;
        while (n != 0) {
            // 如果是奇数，退位会少1，此时把多余的这个矩阵给ans，且最后n一定会到1，所以ans总会和最终的mat相乘得到计算结果
            if ((n & 1) == 1) ans = mul(ans, mat);
            // 每次计算mat=mat^2，所以第k次： mat = mat^2^k，k = logn
            mat = mul(mat, mat);
            n >>= 1; // 退1位
        }
    }

    // 模拟矩阵乘法
    private static int[][] mul(int[][] a, int[][] b) {
        // N就是根据题意推导的矩阵而来的
        int N = 3;
        int[][] c = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }
        return c;
    }

}
