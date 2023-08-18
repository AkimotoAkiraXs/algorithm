package problems.nowcoder.hj;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/3/9 9:11
 */

public class Hj41 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] m = new int[n];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) m[i] = in.nextInt();
        for (int i = 0; i < n; i++) x[i] = in.nextInt();

        Set<Integer> set = new HashSet<>();

        // Hash筛子：经典做法，当暴力会产生大量重复的情况下用Set充当筛子，过滤掉大量重复的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < x[i]; j++) {
                int finalI = i;
                set.addAll(set.stream().map(o -> o + m[finalI]).collect(Collectors.toSet()));
                set.add(m[i]);
            }
        }
        System.out.println(set.size() + 1);
    }

/*
    // 递归暴力，n个set进行剪枝
    static Set<Integer> ans = new HashSet<>();
    static List<Set<Integer>> lists = new ArrayList<>();
    static int n;
    static int[] m = new int[10];
    static int[] x = new int[10];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for (int i = 0; i < n; i++) m[i] = in.nextInt();
        for (int i = 0; i < n; i++) x[i] = in.nextInt();
        for (int i = 0; i < n; i++) lists.add(i, new HashSet<>());

        func(0, 0);
        System.out.println(ans.size());
    }

    public static void func(int k, int w) {
        if (k >= n) {
            ans.add(w);
            return;
        }
        Set<Integer> set = lists.get(k);
        if (set.contains(w)) return;
        else set.add(w);
        for (int i = 0; i <= x[k]; i++) {
            func(k + 1, w + i * m[k]);
        }
    }
*/
}
