package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/13 11:05
 */

public class Hj57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = new StringBuilder(in.nextLine()).reverse().toString();
        String y = new StringBuilder(in.nextLine()).reverse().toString();

        StringBuilder res = new StringBuilder();
        int dec = 0;
        int length = Math.max(x.length(), y.length());
        for (int i = 0; i < length; i++) {
            int a = 0, b = 0;
            if (i < x.length()) a = x.charAt(i) - '0';
            if (i < y.length()) b = y.charAt(i) - '0';
            int sum = a + b + dec;
            dec = sum >= 10 ? 1 : 0;
            res.append(sum % 10);
        }
        if (dec != 0) res.append(dec);
        System.out.println(res.reverse());
    }
}
