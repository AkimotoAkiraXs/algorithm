package nowcoder.hj;

import java.util.Scanner;

/**
 * Dp 最长子序列
 *
 * @author Yuri
 * @since 2023/2/25 5:44
 */

public class Hj24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] nums = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        // todo 最长子序列可以经过二分优化为n*Logn
        // 最长子序列 求出从右边起和从左边起的最长子序列
        for (int l = 0; l < n; l++) {
            left[l] = 1;
            int r = n - l - 1;
            right[r] = 1;
            for (int i = 0; i < l; i++) {
                int rr = n - i - 1;
                if (nums[l] > nums[i]) {
                    left[l] = Math.max(left[i] + 1, left[l]);
                }
                if (nums[r] > nums[rr]) {
                    right[r] = Math.max(right[rr] + 1, right[r]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        // 遍历每个位置以其中 左右两边最长子序列之和-1 最大的值就是理想位置
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i] - 1);
        }
        System.out.println(n - ans);
    }
}
