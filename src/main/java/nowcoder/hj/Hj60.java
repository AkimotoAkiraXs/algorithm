package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/13 11:58
 */

public class Hj60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // 埃氏筛
        boolean[] era = new boolean[n + 1];
        era[0] = era[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (era[i]) continue;
            for (int j = 2; j * i <= n; j++) era[i * j] = true;
        }

        for (int i = n / 2; i >= 2; i--) {
            if (!era[i] && !era[n - i]) {
                System.out.println(i);
                System.out.println(n - i);
                break;
            }
        }
    }
}
