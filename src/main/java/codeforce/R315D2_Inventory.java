package codeforce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/6/2 15:30
 */


public class R315D2_Inventory {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] vis = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            nums[i] = k;
            map.put(k, map.getOrDefault(k, 0) + 1);
            if (k <= n) vis[k] = true;
        }
        int next = 1;
        for (int i = 0; i < n; i++) {
            while (next <= n && vis[next]) next++;
            if (nums[i] > n) {
                sb.append(next++).append(" ");
            } else if (map.get(nums[i]) > 1) {
                map.put(nums[i], map.get(nums[i]) - 1);
                sb.append(next++).append(" ");
            } else {
                sb.append(nums[i]).append(" ");
            }
        }
        System.out.println(sb);
    }

}
