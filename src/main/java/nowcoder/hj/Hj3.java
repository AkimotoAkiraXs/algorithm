package nowcoder.hj;

import java.util.*;

/**
 * @author Yuri
 * @since 2023/2/17 18:43
 */
public class Hj3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        Set<Integer> set = new TreeSet<>();
        while (in.hasNextLong()) {
            int a = in.nextInt();
            set.add(a);
        }
        for (int n : set) System.out.println(n);
    }
}
