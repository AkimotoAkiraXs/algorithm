package nowcoder.hj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/21 21:56
 */

public class Hj26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        StringBuilder sb = Arrays.stream(s.split("")).filter(o -> Character.isLetter(o.charAt(0)))
                .sorted((Comparator.comparingInt(o -> Character.toUpperCase(o.charAt(0)))))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c)) {
                sb.insert(i, c);
            }
        }
        System.out.println(sb);
    }
}
