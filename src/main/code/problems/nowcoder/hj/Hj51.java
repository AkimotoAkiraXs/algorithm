package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/12 11:05
 */

public class Hj51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine(); // 吃掉换行符
            String s = in.nextLine();
            String[] nodes = s.split(" ");
            System.out.println(nodes[n - in.nextInt()]);
        }
    }
}
