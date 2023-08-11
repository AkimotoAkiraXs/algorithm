package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/2/17 22:03
 */

public class Hj9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // distinct去中默认保留前面先出现的元素，因为没找到distinct去重怎么去前面先出现的元素，所以先反转再去重
        s = new StringBuilder(s).reverse().codePoints().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println(s);
    }
}
