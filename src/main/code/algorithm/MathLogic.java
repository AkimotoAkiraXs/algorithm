package algorithm;

import problems.leetcode.editor.cn.FindSubstringWithGivenHashValue;
import problems.leetcode.editor.cn.PerfectSquares;
import problems.nowcoder.hj.Hj107;

/**
 * 数学理论推导集合
 *
 * @author Yuri
 * @since 2023/4/7 17:11
 */
public class MathLogic {

    public static void main(String[] args) {

    }

    /**
     * 牛顿迭代公式：以一种无限逼近方程式结果的迭代公式来求得近似值
     * <p>
     *
     * @see Hj107 Hj107 求解立方根
     * @see <a href="https://zh.wikipedia.org/wiki/%E7%89%9B%E9%A1%BF%E6%B3%95">wiki 牛顿迭代法</a>
     * @see <a href="https://oi-wiki.org/math/newton/">OI 牛顿迭代法</a>
     */
    public static void newtonMethod() {
        double a = 29.9;
        double x = a;
        double eps = 1e-10;
        while (Math.abs(x * x * x - a) > eps) x = (2 * x + a / (x * x)) / (3.0);
        System.out.printf("%.1f", x);
    }

    /**
     * 四平方和定理：四平方和定理证明了任意一个正整数都可以被表示为至多四个正整数的平方和。
     * 同时，n=4^k*(8*m+7)时只能被表示为四个正整数的平方和，否则至多被表示为三个正整数的平方和
     * <p>
     *
     * @see PerfectSquares Lc279 完全平方数
     */
    public static int LagrangeFourSquareTheorem(int n) {
        // 判断n最少可以被几个正整数完全平方和表示
        int x = n;

        // 先判断是否满足n=4^k*(8*m+7)
        while (x % 4 == 0) x /= 4;
        if (x % 8 == 7) return 4;

        // 判断本身是不是平方数
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) return 1;

        // 判断是否为两个数的平方
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if ((int) Math.sqrt(j) * (int) Math.sqrt(j) == j) {
                return 2;
            }
        }

        // 都不是则只有3了
        return 3;
    }

    /**
     * 容斥原理：|A ∪ B ∪ C| = |A|+|B|+|C| - |A ∩ B| - |B ∩ C| - |C ∩ A| + |A ∩ B ∩ C|
     *
     * @see problems.leetcode.editor.cn.SumMultiples 倍数求和
     * @see <a href="https://oi-wiki.org/math/combinatorics/inclusion-exclusion-principle/">容斥原理</a>
     */
    class SumMultiples {

        public int sumOfMultiples(int n) {
            return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
        }

        private int f(int n, int k) {
            int x = n / k;
            return (int) ((x * k + k) / 2.0 * x);
        }
    }

    /**
     * 秦九韶算法/霍纳规则
     * <p>
     * 用于快速求解 a0*p^0 + a1*p^1 + ... + an*p^n的一元n次多项式
     *
     * @see <a href="https://zhuanlan.zhihu.com/p/51300835">秦九韶算法：快速计算多项式的值</a>
     * @see FindSubstringWithGivenHashValue Lc.2156 查找给定哈希值的子串
     */
    class HornerAlgorithm {

        public int horner(int[] a, int p) {
            int n = a.length;
            int hash = 0;
            for (int i = n - 1; i >= 0; i--) { // 从后向前
                hash = hash * p + a[i];
            }
            return hash;
        }
    }


}
