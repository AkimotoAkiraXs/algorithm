package problems.nowcoder.hj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 23:27
 */

public class Hj101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String[] s = in.nextLine().split(" ");
        int k = in.nextInt();
        Arrays.stream(s).map(Integer::parseInt).sorted((o1, o2) -> k == 0 ? o1 - o2 : o2 - o1)
                .forEach(o -> System.out.printf("%d ", o));
    }
}
