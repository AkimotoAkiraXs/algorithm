package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 16:30
 */
public class Hj96 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine().replaceAll("([0-9]+)", "*$1*"));
    }
}
