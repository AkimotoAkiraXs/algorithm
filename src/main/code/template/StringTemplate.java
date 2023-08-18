package template;

/**
 * 字符串相关模板
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

    /**
     * kmp 搜索模板
     */
    class Kmp {
        private int kmp(String str, String match) {
            int[] next = getNext(match);
            int k = -1;
            for (int i = 0; i < str.length(); i++) {
                // 不匹配则回溯，不同于暴力，因为有next数组，所以不用回溯到match最开始
                while (k > -1 && match.charAt(k + 1) != str.charAt(i)) k = next[k];
                if (match.charAt(k + 1) == str.charAt(i)) k++;
                if (k == match.length() - 1) return i - match.length() + 1;// 返回相应的位置
            }
            return -1;
        }

        private int[] getNext(String match) {
            char[] s = match.toCharArray();
            int[] next = new int[s.length];
            next[0] = -1;
            int k = -1;
            for (int i = 1; i < s.length; i++) {
                while (k > -1 && s[k + 1] != s[i]) k = next[k];// 往前回溯，表示缩小k，此时位置i前k个字符与字符串开始k个字符也一定相同
                if (s[k + 1] == s[i]) k++;
                next[i] = k;// 这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
            }
            return next;
        }
    }
}
