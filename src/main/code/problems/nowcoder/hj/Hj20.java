package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/20 16:04
 */

public class Hj20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < s.length() - 3; i++) {
                String substring = s.substring(i, i + 3);
                int lastIndex = s.lastIndexOf(substring);
                if (lastIndex != i) {
                    System.out.println("NG");
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;
            boolean[] bools = new boolean[4];
            for (Character c : s.toCharArray()) {
                boolean digit = Character.isDigit(c);
                bools[0] |= digit;
                boolean upperCase = Character.isUpperCase(c);
                bools[1] |= upperCase;
                boolean lowerCase = Character.isLowerCase(c);
                bools[2] |= lowerCase;
                bools[3] |= !digit & !upperCase & !lowerCase;
            }
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                if (bools[i]) cnt++;
            }
            if (cnt >= 3) {
                System.out.println("OK");
            } else System.out.println("NG");
        }
    }
}
