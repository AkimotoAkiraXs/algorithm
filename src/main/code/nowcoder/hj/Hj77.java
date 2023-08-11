package nowcoder.hj;

import java.util.*;

public class Hj77 {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) queue.addLast(in.nextInt());
        recur(new LinkedList<>(), new LinkedList<>(), queue);
        Collections.sort(res);
        for (String sb : res) {
            System.out.println(sb);
        }
    }

    private static void recur(Deque<Integer> in, Deque<Integer> out, Deque<Integer> queue) {

        if (queue.isEmpty()) {
            if (in.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                while (!out.isEmpty()) sb.append(out.removeFirst()).append(" ");
                res.add(sb.toString());
            }
            return;
        }
        in.addLast(queue.removeFirst());
        Deque<Integer> dIn = new LinkedList<>(in);
        Deque<Integer> dOut = new LinkedList<>(out);

        while (!in.isEmpty()) {
            Integer k = in.removeLast();
            out.addLast(k);
            recur(new LinkedList<>(in), new LinkedList<>(out), new LinkedList<>(queue));
        }
        recur(new LinkedList<>(dIn), new LinkedList<>(dOut), new LinkedList<>(queue));
    }
}
