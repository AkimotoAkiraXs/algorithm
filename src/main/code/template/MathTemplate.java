package template;

import problems.leetcode.editor.cn.ApplyOperationsToMaximizeScore;

import java.util.Arrays;

/**
 * 数学相关模板
 *
 * @author Yuri
 * @since 2023/7/14 16:35
 */


public class MathTemplate {

    private final static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        MathTemplate mathTemplate = new MathTemplate();
        System.out.println(Arrays.toString(mathTemplate.eratosthenes(10000)));
    }

    /**
     * 埃氏筛选法模板 true-合数，false-质数
     * <p>
     * 可以预处理
     */
    private boolean[] eratosthenes(int MAXN) {
        boolean[] vis = new boolean[MAXN];
        vis[0] = vis[1] = true;
        int sqrt = (int) Math.sqrt(MAXN);
        for (int i = 2; i <= sqrt; i++) {
            if (vis[i]) continue;
            for (int j = i; i * j < MAXN; j++) vis[i * j] = true;
        }
        return vis;
    }

    /**
     * 数论：质因子个数用ω（包含重复的，小写omega），不同质因子个数用Ω（不含重复，大写omega）
     * <p>
     * 该模板为快速求0~MAXN的（不同）质因子个数
     * <p>
     * 可以预处理
     *
     * @see ApplyOperationsToMaximizeScore Lc2818 操作使得分最大
     */
    private int[] omega(int MAXN) {
        int[] omega = new int[MAXN + 1];
        for (int i = 2; i < MAXN; i++) {
            if (omega[i] > 0) continue;
            for (int j = 1; j * i < MAXN; j++) omega[i * j] = omega[j] + 1; // 换成omega[i * j]++则是求不同质因子个数
        }
        return omega;
    }

    /**
     * 二进制求幂（矩阵快速幂）
     * <p>
     * 以logn的复杂度快速求幂，一般因为有取余无法调用方法
     */
    private long mfp(long num, int p) {
        if (p == 0) return 1;
        long mfp = mfp(num, p / 2);
        if ((p & 1) == 1) return (mfp * mfp % mod * num) % mod;
        return (mfp * mfp) % mod;
    }

    /**
     * 排列模板 A(n,k)
     */
    private int permutation(int n, int k) {
        int res = 1;
        for (int i = 0; i < k; i++) res *= n--;
        return res;
    }

    /**
     * 组合模板 C(n,k)
     */
    private int combination(int n, int k) {
        if (k > n / 2) k = n - k;
        long a = 1, b = 1;
        for (int i = 0; i < k; i++) {
            a *= n--;
            b *= i + 1;
        }
        return (int) (a / b);
    }

}
