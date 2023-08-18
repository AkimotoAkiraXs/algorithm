package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/18 19:33
 */

public class Hj17 {
    static int x = 0, y = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(";");
        for (String str : strings) {
            if (str.length() == 0) continue;
            switch (str.charAt(0)) {
                case 'A':
                    handler(-1, 0, str);
                    break;
                case 'D':
                    handler(1, 0, str);
                    break;
                case 'S':
                    handler(0, -1, str);
                    break;
                case 'W':
                    handler(0, 1, str);
                    break;
            }
        }
        System.out.println(x + "," + y);
    }

    public static void handler(int a, int b, String string) {
        String str = string.substring(1);
        boolean bool = str.chars().allMatch(Character::isDigit);
        if (bool) {
            int num = Integer.parseInt(str);
            x += a * num;
            y += b * num;
        }
    }
}