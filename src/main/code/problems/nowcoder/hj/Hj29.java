package problems.nowcoder.hj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/25 7:57
 */

public class Hj29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 比起模拟 请用更优雅的字典法
        String dic1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String dic2 = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza1234567890";

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < dic1.length(); i++) {
            map.put((int) dic1.charAt(i), (int) dic2.charAt(i));
            map2.put((int) dic2.charAt(i), (int) dic1.charAt(i));
        }

        String res1 = s1.chars().map(map::get).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        String res2 = s2.chars().map(map2::get).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        System.out.println(res1 + "\n" + res2);

    }
}
