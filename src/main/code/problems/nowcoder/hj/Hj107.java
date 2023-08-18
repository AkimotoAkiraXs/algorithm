package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/7 17:14
 */
public class Hj107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 牛顿迭代公式
        double a = in.nextDouble();
        double x = a;
        double eps = 1e-10;
        while (Math.abs(x * x * x - a) > eps) x = (2 * x + a / (x * x)) / (3.0);
        System.out.printf("%.1f", x);
    }
}
