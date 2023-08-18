package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/8 13:20
 */

public class Hj38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double d = in.nextDouble();
        double sum = d; // 第一次落下
        for (int i = 0; i < 4; i++) {
            sum += d;
            d /= 2;
        }
        System.out.println(sum);
        System.out.println(d/2);
    }
}
