package problems.nowcoder.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/10 1:31
 */

public class Hj48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println("null");
            return;
        }
        List<Integer> list = new ArrayList<>();
        list.add(in.nextInt());
        for (int i = 1; i < n; i += 1) {
            int num = in.nextInt();
            int pre = in.nextInt();
            int dir = list.indexOf(pre);
            list.add(dir + 1, num);
        }
        list.remove((Integer) in.nextInt());
        for (Integer num : list) {
            System.out.printf("%d ", num);
        }
    }
}
