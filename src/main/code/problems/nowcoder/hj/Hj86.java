package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 10:05
 */
public class Hj86 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String bin = Integer.toBinaryString(n);
        int max = 0, cnt = 0;
        for (Character c : bin.toCharArray()) {
            if (c == '1') max = Math.max(max, ++cnt);
            else cnt = 0;
        }
        System.out.println(max);
    }
}
