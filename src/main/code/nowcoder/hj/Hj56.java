package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/13 10:56
 */

public class Hj56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for (int i = 2; i <= n; i++) {
            int sum = 1;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sum += j + i / j;
                }
            }
            if (sum == i) res++;
        }
        System.out.println(res);
    }
}
