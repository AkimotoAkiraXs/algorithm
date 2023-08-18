package problems.nowcoder.hj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/21 22:40
 */

public class Hj25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> res = new ArrayList<>();
        int i = in.nextInt();
        int[] I = new int[i];
        for (int j = 0; j < i; j++) I[j] = in.nextInt();
        int r = in.nextInt();
        int[] R = new int[r];
        for (int j = 0; j < r; j++) R[j] = in.nextInt();

        // Java8坑，当（peek）内容被忽略，则不会执行其中的逻辑
        int[] ints = Arrays.stream(R).distinct().sorted().peek(o -> {
            int index = res.size();
            String match = Integer.toString(o);
            for (int j = 0; j < i; j++) {
                int num = I[j];
                if (Integer.toString(num).contains(match)) {
                    res.add(j);
                    res.add(num);
                }
            }
            if (res.size() != index) {
                // 先压数量再压匹配数
                res.add(index, (res.size() - index) / 2);
                res.add(index, o);
            }
        }).toArray();
        System.out.printf("%d ", res.size());
        for (Integer re : res) System.out.printf("%d ", re);
    }
}
