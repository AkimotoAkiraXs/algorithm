package template;

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

    // 字符串乘法
    private String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] d = new int[num1.length() + num2.length()];

        for (int i = 0; i < n1.length(); i++)
            for (int j = 0; j < n2.length(); j++)
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i + 1 < d.length)
                d[i + 1] += carry;
            sb.insert(0, mod);
        }
        while (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
        return sb.toString();
    }
}
