package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/14 9:14
 */

public class Hj63 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dna = in.nextLine();
        int n = in.nextInt();
        String res = dna.substring(0, n);
        int max = 0;
        for (Character c : res.toCharArray()) {
            if (c == 'G' || c == 'C') max++;
        }
        int cur = max;
        for (int i = n; i < dna.length(); i++) {
            char x = dna.charAt(i - n);
            if (x == 'G' || x == 'C') cur--;
            char y = dna.charAt(i);
            if (y == 'G' || y == 'C') cur++;
            if (cur > max) {
                max = cur;
                res = dna.substring(i - n + 1, i + 1);
            }
        }
        System.out.println(res);
    }
}
