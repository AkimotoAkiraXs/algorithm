package akimoto.akira.algorithm;

import java.util.*;

/**
 * @author Yuri
 * @since 2022/4/12 11:55
 */
public class AkiraSQuestion {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("In:");
        int n;
        while ((n = in.nextInt()) != 0) {
            n = n != 1 ? n : 14;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> ans = null;
        int i = 3;
        int max = 5;
        while (i <= 10) {
            int k = 0;
            List<Integer> temp = new ArrayList<>();
            for (; i <= 14 && (map.getOrDefault(i, 0) < 4); ++i) {
                temp.add(i != 14 ? i : 1);
                k++;
            }
            i++;
            if (k >= max) {
                ans = new ArrayList<>(temp);
                max = k;
            }
        }
        System.out.println(
                ans == null ? "NO PASS" : ans
        );

    }
}
