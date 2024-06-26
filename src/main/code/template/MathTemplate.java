package template;

import problems.leetcode.editor.cn.ApplyOperationsToMaximizeScore;

/**
 * 数学相关模板
 *
 * @author Yuri
 * @since 2023/7/14 16:35
 */


public class MathTemplate {

    public static void main(String[] args) {
        MathTemplate mathTemplate = new MathTemplate();
        System.out.println(mathTemplate.combination(31, 15));
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
    private long mfp(long num, int p, int mod) {
        if (p == 0) return 1;
        long mfp = mfp(num, p / 2, mod);
        if ((p & 1) == 1) return (mfp * mfp % mod * num) % mod;
        return (mfp * mfp) % mod;
    }

    /**
     * 排列模板 A(n,k)
     */
    private long permutation(int n, int k) {
        if (n < k) return 0;
        long res = 1;
        while (k-- > 0) res *= n--;
        return res;
    }

    /**
     * 组合模板 C(n,k)
     */
    private long combination(int n, int k) {
        if (n < k) return 0;
        long a = 1, b = 1;
        while (k > 0) {
            a *= n--;
            b *= k--;
            // int gcd = gcd(a, b);
            // a /= gcd;
            // b /= gcd;
        }
        return a / b;
    }


    private int gcd(int a, int b) {
        if (b == 0) return a;
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        return gcd(b, a % b);
    }

}
