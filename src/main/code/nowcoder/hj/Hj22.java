package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/21 0:47
 */

public class Hj22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while ((n = in.nextInt()) != 0) {
            int res = 0;
            while (n >= 3) {
                int l = n % 3;
                n /= 3;
                res += n;
                n += l;
            }
            if (n == 2) res++;
            System.out.println(res);
        }
    }
}
