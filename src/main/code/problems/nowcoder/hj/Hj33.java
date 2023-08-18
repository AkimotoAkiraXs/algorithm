package problems.nowcoder.hj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/26 1:07
 */

public class Hj33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] strings = s.split("\\.");
        DecimalFormat format = new DecimalFormat("00000000");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String str = strings[i];
            String bin = Integer.toBinaryString(Integer.parseInt(str));
            sb.append(format.format(Integer.valueOf(bin)));
        }
        long res = Long.parseLong(sb.toString(), 2);
        System.out.println(res);

        long num = Long.parseLong(in.nextLine());
        long k = Long.parseLong("11111111", 2) << 24;
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            long l = (num & k) >> ((3 - i) * 8);
            sb2.append(l);
            if (i < 3) {
                sb2.append(".");
                k >>= 8;
            }
        }
        System.out.println(sb2);
    }
}
