package problems.nowcoder.hj;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Yuri
 * @since 2023/2/25 8:58
 */

public class Hj30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String str = Arrays.stream(s.split(" ")).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        String odd = getStr(str, true);
        String even = getStr(str, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < odd.length(); i++) {
            sb.append(handleChar(odd.charAt(i)));
            if (i < even.length()) sb.append(handleChar(even.charAt(i)));
        }
        System.out.println(sb);
    }

    public static String handleChar(Character c) {
        if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || ((c >= 'a' && c <= 'f'))) {
            DecimalFormat format = new DecimalFormat("0000");
            String bin = Integer.toBinaryString(Integer.parseInt(Character.toString(c), 16));
            int dec = Integer.parseInt(new StringBuilder(format.format(Integer.valueOf(bin))).reverse().toString(), 2);
            String res = Integer.toHexString(dec);
            char cc = res.charAt(0);
            if (Character.isLowerCase(cc)) return String.valueOf(Character.toUpperCase(cc));
            return res;
        }
        return c.toString();
    }

    public static String getStr(String str, boolean flag) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(flag);
        return str.chars().filter(o -> {
            if (atomicBoolean.get()) {
                atomicBoolean.set(false);
                return true;
            } else {
                atomicBoolean.set(true);
                return false;
            }
        }).sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}