package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/13 10:04
 */

public class Hj53 {
    // 数据范围1≤n≤10^9，所以暴力以模拟时不合理的，此题肯定是找规律题，通过多画几行能发现规律是2 3 2 4，第一行和第二行没有偶数
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] law = {2, 3, 2, 4}; // 规律
        while (in.hasNextInt()) {
            int n = in.nextInt() - 1;
            int res;
            if (n == 0 || n == 1) res = -1;
            else res = law[(n - 2) % 4];
            System.out.println(res);
        }
    }
}
