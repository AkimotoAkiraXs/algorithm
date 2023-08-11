package nowcoder.hj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/20 10:40
 */

public class Hj18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res = new int[7];
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] strings = s.split("~");
            String ip = strings[0];
            String cc = strings[1];
            if (s.startsWith("127")) continue;
            long x = convert(ip);
            if (x == -1) {
                res[5]++;
                continue;
            }

            long y = convert(cc, true);
            if (y <= 0 || y >= convert("255.255.255.255")) {
                res[5]++;
                continue;
            }

            // 127特殊不标记网址
            if ((x >= convert("127.0.0.0") && x <= convert("127.255.255.255")) || (x >= 0 && x <= convert("0.255.255.255"))) {
                continue;
            }

            // 私网
            if ((x >= convert("10.0.0.0") && x <= convert("10.255.255.255")) ||
                    (x >= convert("172.16.0.0") && x <= convert("172.31.255.255"))
                    || (x >= convert("192.168.0.0") && x <= convert("192.168.255.255"))) {
                res[6]++;
            }
            if (x >= convert("1.0.0.0") && x <= convert("126.255.255.255")) res[0]++;
            else if (x >= convert("128.0.0.0") && x <= convert("191.255.255.255")) res[1]++;
            else if (x >= convert("192.0.0.0") && x <= convert("223.255.255.255")) res[2]++;
            else if (x >= convert("224.0.0.0") && x <= convert("239.255.255.255")) res[3]++;
            else if (x >= convert("240.0.0.0") && x <= convert("255.255.255.255")) res[4]++;
        }
        for (int num : res) System.out.printf("%d ", num);
    }

    public static long convert(String s, boolean flag) {
        String[] strings = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        if (strings.length == 0 || strings.length > 4) {
            return -1;
        }
        for (String str : strings) {
            if (str == null || str.equals("")) {
                return -1;
            }
            int dec = Integer.parseInt(str);
            String bin = Integer.toBinaryString(dec);
            DecimalFormat format = new DecimalFormat("00000000");
            bin = format.format(Integer.valueOf(bin));
            sb.append(bin);
        }
        if (flag && sb.toString().contains("01")) return -1;
        return Long.parseLong(sb.toString(), 2);
    }

    public static long convert(String s) {
        return convert(s, false);
    }
}
