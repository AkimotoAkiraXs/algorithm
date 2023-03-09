package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/9 8:20
 */

public class Hj40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int a,b,c,d;
        a = b = c = d = 0;
        for (Character cc : s.toCharArray()) {
            if ((cc >= 'a' && cc <= 'z') || (cc >= 'A' && cc <= 'Z')) a++;
            else if (cc == ' ') b++;
            else if (cc >='0' && cc <= '9') c++;
            else d++;
        }
        System.out.printf("%d\n%d\n%d\n%d", a, b, c, d);
    }
}
