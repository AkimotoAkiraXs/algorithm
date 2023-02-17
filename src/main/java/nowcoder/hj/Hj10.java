package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/17 22:07
 */

public class Hj10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int length = s.codePoints().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).length();
        System.out.println(length);
    }
}
