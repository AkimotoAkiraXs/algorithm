package algorithm.template;

import java.util.Arrays;

/**
 * @author Yuri
 * @since 2023/7/14 16:35
 */


public class MathTemplate {

    public static void main(String[] args) {
        MathTemplate mathTemplate = new MathTemplate();
        System.out.println(Arrays.toString(mathTemplate.eratosthenes(10000)));
    }


    // 埃氏筛选法模板 true-合数，false-质数
    private boolean[] eratosthenes(int MAX_N) {
        boolean[] vis = new boolean[MAX_N];
        vis[0] = vis[1] = true;
        int sqrt = (int) Math.sqrt(MAX_N);
        for (int i = 2; i <= sqrt; i++) {
            if (vis[i]) continue;
            for (int j = i; i * j < MAX_N; j++) vis[i * j] = true;
        }
        return vis;
    }

    // 排列模板 A(n,k)
    private int permutation(int n, int k) {
        int res = 1;
        for (int i = 0; i < k; i++) res *= n--;
        return res;
    }

    // 组合模板 C(n,k)
    private int combination(int n, int k) {
        if (k > n / 2) k = n - k;
        long a = 1, b = 1;
        for (int i = 0; i < k; i++) {
            a *= n--;
            b *= i + 1;
        }
        return (int) (a / b);
    }

}
