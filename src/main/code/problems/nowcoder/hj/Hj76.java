package problems.nowcoder.hj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/28 23:14
 */

public class Hj76 {

    // 数学 n*n是n个连续数的中间值
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        int n = in.nextInt();
        int square = n * n;
        int left = square;
        int right = square;
        if ((square & 1) == 0) {
            left -= 1;
            right += 1;
        } else {
            left -= 2;
            right += 2;
            n--;
            deque.add(square);
        }
        while (n > 0) {
            deque.addFirst(left);
            deque.addLast(right);
            left -= 2;
            right += 2;
            n -= 2;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer k : deque) sb.append(k).append("+");
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
