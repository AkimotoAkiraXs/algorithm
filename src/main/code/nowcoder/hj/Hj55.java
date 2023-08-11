package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/13 10:48
 */

public class Hj55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) res++;
            else if (String.valueOf(i).contains("7")) res++;
        }
        System.out.println(res);
    }
}
