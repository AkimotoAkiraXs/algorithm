package problems.nowcoder.hj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/2/25 23:59
 */

public class Hj31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        StringBuilder sb = s.chars().map(o -> {
            if (!Character.isLetter(o)) return ' ';
            return o;
        }).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
        List<String> list = Arrays.stream(sb.toString().split(" ")).filter(o -> !o.isEmpty()).collect(Collectors.toList());
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
