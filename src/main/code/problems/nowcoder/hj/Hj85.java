package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * 本题用的中心扩展法，除此之外暴力、Dp都可以做
 *
 * @author Yuri
 * @since 2023/4/4 18:52
 */
public class Hj85 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            int a = i, b = i + 1;
            int cnt = 0;
            while (a >= 0 && b < s.length() && s.charAt(a--) == s.charAt(b++)) cnt += 2;
            max = Math.max(cnt, max);

            a = i - 1;
            b = i + 1;
            cnt = 1;
            while (a >= 0 && b < s.length() && s.charAt(a--) == s.charAt(b++)) cnt += 2;
            max = Math.max(cnt, max);
        }
        System.out.println(max);
    }

}
