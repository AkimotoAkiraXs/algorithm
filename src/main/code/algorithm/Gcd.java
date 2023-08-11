package algorithm;

/**
 * Euclidean algorithm: 又叫欧几里得算法、辗转相除法，用于求两个正整数的最大公约数(Greatest Common Divisor)的算法。
 *
 * @author Yuri
 * @see <a href="https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/1647675">百度百科-欧几里得算法</a>
 * @see <a href="https://zh.m.wikipedia.org/zh-hans/%E8%BC%BE%E8%BD%89%E7%9B%B8%E9%99%A4%E6%B3%95">Wiki-辗转相除法</a>
 * @since 2022/6/27 15:22
 */
public class Gcd {

    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        int a = 1071, b = 462;
        int gcdNumber = gcd.gcd(a, b);
        int lcmNumber = (a * b) / gcdNumber; // lcm(a,b) * gcd(a,b) = a * b
        System.out.println("最大公约数:" + gcdNumber);
        System.out.println("最小公倍数:" + lcmNumber);
    }

    /**
     * <h2>默认：a > b</h2>
     * 关于最大公约数定义和欧几里得算法证明可以通过：
     * <a href="https://zh.m.wikipedia.org/zh-hans/%E8%BC%BE%E8%BD%89%E7%9B%B8%E9%99%A4%E6%B3%95">Wiki-辗转相除法</a>
     * 中数形结合通过面积讲解的方式理解。
     * 关于lcm(a,b) * gcd(a,b) = a * b证明：<a href="https://blog.csdn.net/qq_41437512/article/details/109002170">最小公倍数一些性质定理及证明</a>
     */
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
