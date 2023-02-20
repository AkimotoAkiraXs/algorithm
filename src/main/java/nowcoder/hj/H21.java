package nowcoder.hj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/21 0:38
 */

public class H21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int dis = 'A' - 'b';
        String s = in.nextLine();
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : "abc".toCharArray()) map.put(c, 2);
        for (Character c : "def".toCharArray()) map.put(c, 3);
        for (Character c : "ghi".toCharArray()) map.put(c, 4);
        for (Character c : "jkl".toCharArray()) map.put(c, 5);
        for (Character c : "mno".toCharArray()) map.put(c, 6);
        for (Character c : "pqrs".toCharArray()) map.put(c, 7);
        for (Character c : "tuv".toCharArray()) map.put(c, 8);
        for (Character c : "wxyz".toCharArray()) map.put(c, 9);

        s = s.chars().map(o -> {
            if (Character.isUpperCase(o)) {
                if (o == 'Z') o = 'a';
                else o = (char) (o - dis);
            } else if (Character.isLowerCase(o)) o = map.get((char) o) + '0';
            return o;
        }).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println(s);
    }
}
