package problems.nowcoder.hj;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/3/10 1:10
 */

public class Hj45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            int res = 0;
            String s = in.nextLine();
            Map<String, Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Set<Map.Entry<String, Long>> entries = map.entrySet();
            entries = entries.stream().sorted(((o1, o2) -> (int) (o2.getValue() - o1.getValue()))).collect(Collectors.toCollection(LinkedHashSet::new));
            int k = 26;
            for (Map.Entry<String, Long> entry : entries) {
                res += entry.getValue() * k--;
            }
            System.out.println(res);
        }
    }
}
