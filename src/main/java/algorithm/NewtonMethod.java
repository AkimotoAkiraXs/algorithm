package algorithm;

/**
 * <p>牛顿迭代公式：以一种无限逼近方程式结果的迭代公式来求得近似值
 *
 * <p>求解三次方方程 {@link nowcoder.hj.Hj107 求解立方根}
 *
 * @author Yuri
 * @see <a href="https://zh.wikipedia.org/wiki/%E7%89%9B%E9%A1%BF%E6%B3%95">wiki 牛顿迭代法</a>
 * @see <a href="https://oi-wiki.org/math/newton/">OI 牛顿迭代法</a>
 * @since 2023/4/7 17:11
 */
public class NewtonMethod {
    public static void main(String[] args) {
        // 牛顿迭代公式
        double a = 29.9;
        double x = a;
        double eps = 1e-10;
        while (Math.abs(x * x * x - a) > eps) x = (2 * x + a / (x * x)) / (3.0);
        System.out.printf("%.1f", x);
    }
}
