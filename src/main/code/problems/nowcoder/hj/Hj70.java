package problems.nowcoder.hj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/21 17:31
 */

public class Hj70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Index[] indexs = new Index[n];
        for (int i = 0; i < n; i++) {
            indexs[i] = new Index(in.nextInt(), in.nextInt());
        }
        in.nextLine();
        String order = in.nextLine();
        Deque<Character> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (c == '(') stack.add(c);
            else if (c == ')') {
                stack.removeLastOccurrence('(');
                while (stack.size() > 1) {
                    Character c1 = stack.removeLast();
                    Character c2 = stack.peekLast();
                    if (c1  == '(' || c2 == '('){
                        stack.add(c1);
                        break;
                    }
                    Index a = indexs[c2 - 'A'];
                    Index b = indexs[c1 - 'A'];
                    res += a.x * a.y * b.y;
                    a.y = b.y;
                }
            } else if (stack.isEmpty() || stack.peekLast() == '(') {
                stack.add(c);
            } else {
                Character k = stack.peekLast();
                Index a = indexs[k - 'A'];
                Index b = indexs[c - 'A'];
                res += a.x * a.y * b.y;
                a.y = b.y;
            }
        }
        while (stack.size() > 1) {
            Character c1 = stack.removeLast();
            Character c2 = stack.peekLast();
            Index a = indexs[c2 - 'A'];
            Index b = indexs[c1 - 'A'];
            res += a.x * a.y * b.y;
            a.y = b.y;
        }
        System.out.println(res);
    }

    private static class Index {
        int x;
        int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
