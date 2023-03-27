package nowcoder.hj;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/3/13 11:36
 */

public class Hj60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Map<String, Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Character c : s.toCharArray()) {
            if (map.get(String.valueOf(c)) == 1) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("-1");
    }

}
