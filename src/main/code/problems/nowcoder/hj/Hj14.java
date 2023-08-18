package problems.nowcoder.hj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/17 22:53
 */

public class Hj14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        // n不能开大了，不然Arrays.sort()会爆空指针
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.nextLine();
        }
//        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings);
        for (int i = 0; i < n; i++) {
            System.out.println(strings[i]);
        }
    }
}
