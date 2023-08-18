package problems.nowcoder.hj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/2/25 6:10
 */

public class Hj27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split(" ");
        int length = strings.length;
        int k = Integer.parseInt(strings[length - 1]);
        String str = strings[strings.length - 2];
        String match = str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        strings[0] = strings[length - 1] = strings[length - 2] = "";
        List<String> list = Arrays.stream(strings).filter(o -> !o.isEmpty()).sorted().collect(Collectors.toList());

        int cnt = 0;
        String res = "";
        for (String string : list) {
            String sort = string.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            if (!str.equals(string) && match.equals(sort) && ++cnt == k) {
                res = string;
            }
        }
        System.out.printf("%d\n%s", cnt, res);
    }
}
