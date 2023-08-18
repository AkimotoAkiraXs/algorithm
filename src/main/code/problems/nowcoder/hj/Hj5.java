package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/17 19:30
 */

public class Hj5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.substring(2);
        System.out.println(Integer.parseInt(s, 16));
    }
}
