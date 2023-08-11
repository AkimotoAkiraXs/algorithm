package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 23:08
 */

public class Hj99 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            if (String.valueOf(i*i).endsWith(String.valueOf(i))) cnt++;
        }
        System.out.println(cnt);
    }
}
