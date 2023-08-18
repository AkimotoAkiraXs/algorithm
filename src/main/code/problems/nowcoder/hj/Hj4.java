package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/17 19:18
 */

public class Hj4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int num = (8 - s.length() % 8) % 8;
        for (int i = 0; i < s.length(); ) {
            for (int k = 0; i < s.length() && k < 8; i++, k++) {
                System.out.print(s.charAt(i));
            }
            if (i != s.length()) System.out.println();
        }
        for (int i = 0; i < num; i++) {
            System.out.print("0");
        }
    }
}
