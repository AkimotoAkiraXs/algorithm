package problems.nowcoder.hj;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/2/17 22:37
 */

public class Hj13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> list = Arrays.stream(s.split(" ")).collect(Collectors.toList());
        Collections.reverse(list);
        String res = String.join(" ", list);
        System.out.println(res);
    }
}
