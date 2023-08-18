package problems.nowcoder.hj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/3/14 12:28
 */

public class Hj67 {

    static int cnt = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(dfs(list));
//        System.out.println(cnt);
    }

    public static boolean dfs(List<Integer> list) {
        if (list.size() == 1) return list.remove(0) == 24;
        boolean res = false;
        for (int i = 0; i < list.size() - 1 && !res; i++) {
            for (int j = i + 1; j < list.size() && !res; j++) {
                cnt++;
                List<Integer> temp = new ArrayList<>(list);
                Integer a = temp.get(i);
                Integer b = temp.remove(j);
                temp.set(0, a + b);
                List<Integer> add = new ArrayList<>(temp);
                temp.set(0, a * b);
                List<Integer> mul = new ArrayList<>(temp);
                temp.set(0, a - b);
                List<Integer> sub = new ArrayList<>(temp);
                res = dfs(add) || dfs(mul) || dfs(sub);
                if (!res && b != 0) {
                    temp.set(0, a / b);
                    List<Integer> div = new ArrayList<>(temp);
                    res = dfs(div);
                }
            }
        }
        return res;
    }
}
