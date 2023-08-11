package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/21 16:02
 */

public class Hj69 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int[][] A = new int[x][y];
        int[][] B = new int[y][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                A[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < z; j++) {
                B[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                int sum = 0;
                for (int k = 0; k < y; k++) {
                    sum += A[i][k] * B[k][j];
                }
                System.out.printf("%d ", sum);
            }
            System.out.println();
        }
    }
}
