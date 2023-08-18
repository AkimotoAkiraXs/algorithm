package problems.nowcoder.hj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/14 9:40
 */

public class Hj64 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String order = in.nextLine();
        int cur = 1;
        Deque<Integer> page = init(n, true);
        for (Character o : order.toCharArray()) {
            if (o == 'U') {
                if (cur == 1) {
                    cur = n;
                    page = init(n, false);
                } else {
                    cur--;
                    if (!page.contains(cur)) {
                        page.removeLast();
                        page.addFirst(cur);
                    }
                }
            } else {
                if (cur == n) {
                    cur = 1;
                    page = init(n, true);
                }else {
                    cur++;
                    if (!page.contains(cur)) {
                        page.removeFirst();
                        page.add(cur);
                    }
                }
            }
        }
        while (!page.isEmpty()){
            System.out.printf("%d ", page.removeFirst());
        }
        System.out.println();
        System.out.println(cur);
    }

    public static Deque<Integer> init(int n, boolean flag) {
        Deque<Integer> page = new LinkedList<>();
        if (flag) for (int i = 1; i <= Math.min(4, n); i++) page.add(i);
        else for (int i = Math.max(n - 3, 1); i <= n; i++) page.add(i);
        return page;
    }
}
