package nowcoder.hj;

import java.util.Scanner;

/**
 * 中心扩展法
 *
 * @author Yuri
 * @see leetcode.editor.cn.LongestPalindromicSubstring 动态规划 解法
 * @since 2023/2/26 0:36
 */

public class Hj32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int l, r;
        int length = s.length();
        int max = 1;
        // 避开了动态规划使用中心扩展法
        for (int i = 1; i < length; i++) {
            l = i - 1;
            r = i;
            int cnt = 0;
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                cnt += 2;
                l--;
                r++;
            }
            max = Math.max(max, cnt);
            l = i - 1;
            r = i + 1;
            cnt = 1;
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                cnt += 2;
                l--;
                r++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
