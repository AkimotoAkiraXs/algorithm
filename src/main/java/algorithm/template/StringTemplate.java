package algorithm.template;

/**
 * 代码模板
 *
 * @author Yuri
 * @since 2023/7/3 19:33
 */

public class StringTemplate {


    /**
     * 字符串加法
     */
    private String add(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int carry = 0; // 进位符
        int max = Math.max(len1, len2);
        StringBuilder res = new StringBuilder();
        while (max-- > 0) {
            int a = len1 > 0 ? s1.charAt(--len1) - '0' : 0;
            int b = len2 > 0 ? s2.charAt(--len2) - '0' : 0;
            res.append((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
