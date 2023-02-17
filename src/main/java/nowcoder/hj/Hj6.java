package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/17 19:45
 */

public class Hj6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 不要用埃氏筛选法，数过大，空间开大了会爆内存
        int n = Integer.parseInt(in.nextLine());
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                n /= i;
                System.out.print(i + " ");
            }
        }
        if (n > 1) System.out.print(n);
    }
}
