package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/7 17:32
 */
public class Hj108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        System.out.println(x * y / gcd(x, y));
    }

    private static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
