package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 10:23
 */
public class Hj87 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        int score = 0;
        if (code.length() >= 8) score += 25;
        else if (code.length() >= 5) score += 10;
        else score += 5;
        int lowCase, upCase, digit, chr;
        lowCase = upCase = digit = chr = 0;

        for (Character c : code.toCharArray()) {
            if (Character.isUpperCase(c)) upCase++;
            else if (Character.isLowerCase(c)) lowCase++;
            else if (Character.isDigit(c)) digit++;
            else chr++;
        }
        if (lowCase > 0 && upCase > 0) score += 20;
        else if (lowCase > 0 || upCase > 0) score += 10;
        if (digit > 1) score += 20;
        else if (digit > 0) score += 10;
        if (chr > 1) score += 25;
        else if (chr > 0) score += 10;
        if (upCase > 0 && lowCase > 0 && digit > 0 && chr > 0) score += 5;
        else if ((upCase + lowCase) > 0 && digit > 0 && chr > 0) score += 3;
        else if ((upCase + lowCase) > 0 && digit > 0) score += 2;
        output(score);
    }

    private static void output(int score) {
        if (score >= 90) System.out.println("VERY_SECURE");
        else if (score >= 80) System.out.println("SECURE");
        else if (score >= 70) System.out.println("VERY_STRONG");
        else if (score >= 60) System.out.println("STRONG");
        else if (score >= 50) System.out.println("AVERAGE");
        else if (score >= 25) System.out.println("WEAK");
        else if (score >= 0) System.out.println("VERY_WEAK");
    }
}
