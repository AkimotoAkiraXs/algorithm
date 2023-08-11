package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/8 12:29
 */

public class Hj35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // 不要去推数字变化规律，会把自己绕晕，直接按照题目要求以三角矩阵从1~n注入值再输出就好
        int[][] ary = new int[n][n];
        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                ary[i - j][j] = k++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%d ", ary[i][j]);
            }
            System.out.println();
        }
    }
}
