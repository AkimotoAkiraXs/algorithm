package nowcoder.hj;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yuri
 * @since 2023/4/6 15:04
 */
public class Hj94 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();
        AtomicInteger inVal = new AtomicInteger();
        in.nextLine();
        Arrays.stream(in.nextLine().split(" ")).forEach(o -> map.put(o, 0));
        in.nextLine();
        Arrays.stream(in.nextLine().split(" ")).forEach(o -> {
            if (map.containsKey(o)) map.put(o, map.get(o) + 1);
            else inVal.getAndIncrement();
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Invalid : " + inVal);
    }
}
