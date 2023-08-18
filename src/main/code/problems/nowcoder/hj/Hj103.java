package problems.nowcoder.hj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/7 15:43
 */
public class Hj103 {
    // dp：最长升序子序列
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        Integer[] nums = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] dp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        System.out.println(Collections.max(Arrays.asList(dp)));
    }


/*
    // 暴力dfs深搜，O(2^(n+1))
    static int max;
    static Integer[] nums;
    static int cnt;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        nums = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        max = 0;
        cnt = 0;
        dfs(0, 0, 0);
        // System.out.println(cnt);
        System.out.println(max);
    }

    private static void dfs(int k, int len, int high) {
        cnt++;
        if (k == nums.length) {
            max = Math.max(max, len);
            return;
        }
        Integer num = nums[k];
        if (num > high) dfs(k + 1, len + 1, num);
        dfs(k + 1, len, high);
    }
*/
}
