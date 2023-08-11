package nowcoder.hj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/8 12:52
 */

public class Hj36 {
    // 先映射字典再遍历
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        Map<Character, Character> map = new HashMap<>();
        code = code.chars().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        char key = 'a';
        for (Character c : code.toCharArray()) map.put(key++, c);
        char value = 'a';
        for (; key <= 'z'; key++) {
            while (map.containsValue(value)) value++;
            map.put(key, value);
        }

        String str = in.nextLine();
        for (Character c : str.toCharArray()) System.out.printf("%c", map.get(c));
    }
}
