package nowcoder.hj;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Yuri
 * @since 2023/2/17 21:34
 */

public class Hj8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int index = in.nextInt();
            int value = in.nextInt();
            map.put(index, map.getOrDefault(index, 0) + value);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.printf("%d %d\n", entry.getKey(), entry.getValue());
        }
    }
}
