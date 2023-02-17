package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/17 19:00
 */

public class Hj2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String cr = in.nextLine();
        char c = cr.charAt(0);
        if (c >= 'A' && c <= 'A' + 26) {
            s = s.toUpperCase();
        } else if (c >= 'a' && c <= 'a' + 26) {
            s = s.toLowerCase();
        }
        int cnt = 0;
        for (char i : s.toCharArray()) {
            if (i == c ) cnt++;
        }
        System.out.println(cnt);
    }
}
