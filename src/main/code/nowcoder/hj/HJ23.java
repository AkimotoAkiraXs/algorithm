package nowcoder.hj;

import java.util.*;

/**
 * @author Yuri
 * @since 2023/2/17 18:43
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        StringBuilder sb = new StringBuilder();

        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int[] cnt = new int[26];
            for (int i = 0; i < 26; i++) {
                cnt[i] = -1;
            }
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                cnt[aChar - 'a']++;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] != -1) {
                    min = Math.min(cnt[i], min);
                }
            }
            for (char c : chars) {
                int num = cnt[c - 'a'];
                if (num > min) {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean[] er() {
        return new boolean[0];
    }
}
