package problems.nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/17 18:43
 */

public class Hj1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        String[] ary = s.split(" ");
        System.out.println(ary[ary.length - 1].length());
    }
}
