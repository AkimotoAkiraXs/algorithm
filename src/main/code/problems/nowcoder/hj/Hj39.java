package problems.nowcoder.hj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/9 8:16
 */

public class Hj39 {
    static boolean flag;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            flag = false;
            String mask = func(in.nextLine());
            String ip1 = func(in.nextLine());
            String ip2 = func(in.nextLine());

            if (flag || mask.contains("01")){
                System.out.println(1);
                continue;
            }
            long m = Long.parseLong(mask, 2);
            long x = Long.parseLong(ip1, 2);
            long y = Long.parseLong(ip2, 2);
            if ((m & x) == (m & y)) System.out.println(0);
            else System.out.println(2);
        }
    }

    public static String func(String str) {
        String[] strings = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String string = strings[i];
            int num = Integer.parseInt(string);
            if (num > 255 || num < 0) {
                flag = true;
                return "";
            }
            DecimalFormat format = new DecimalFormat("00000000");
            String bin = format.format(Long.valueOf(Long.toBinaryString(num)));
            sb.append(bin);
        }
        return sb + "";
    }
}
