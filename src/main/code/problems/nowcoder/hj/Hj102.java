package problems.nowcoder.hj;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/4/6 23:32
 */

public class Hj102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Long> map = Arrays.stream(in.nextLine().split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream().sorted((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return (int) (o2.getValue() - o1.getValue());
        }).forEach(o -> System.out.printf("%s", o.getKey()));

    }
}
