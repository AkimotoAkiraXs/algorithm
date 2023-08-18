package problems.nowcoder.hj;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 14:09
 */
public class Hj90 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            boolean flag = true;
            String ip = in.nextLine();
            String[] split = ip.split("\\.");
            if (split.length != 4) flag = false;
            for (String str : split) {
                if ((str.length() > 1 && str.startsWith("0")) || Objects.equals(str, "") || Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255) {
                    flag = false;
                }
                for (Character c : str.toCharArray()) if (!Character.isDigit(c)) flag = false;
            }
            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
