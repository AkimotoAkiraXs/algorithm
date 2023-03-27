package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/27 23:56
 */

public class Hj71 {
    private static String regex;
    private static String s;

    // 可以用replaceAll做但是没意义
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(in.nextLine().toLowerCase());
        for (int i = 0; i < sb.length() - 1; ) {
            if (sb.charAt(i) == '*' && sb.charAt(i + 1) == '*') sb.deleteCharAt(i); //将**、***等处理为*
            else i++;
        }
        regex = sb.toString();
        s = in.nextLine().toLowerCase();
        System.out.println(recur(0, 0));

    }

    // 递归思路：把连续的*处理为单个*，匹配后面一个字符与匹配字符串中相等的情况，匹配一次进一次recur，?则是匹配所有数字字母
    private static boolean recur(int x, int y) {
        boolean flag = false;
        while (x < regex.length() && y < s.length() && !flag) {
            char a = regex.charAt(x);
            char b = s.charAt(y);
            if (a == '?' && !Character.isLetter(b) && !Character.isDigit(b)) return false;
            else if (a == '?' || a == b) {
                x++;
                y++;
            } else if (a == '*') {
                if (x == regex.length() - 1) return true;
                else {
                    a = regex.charAt(++x);
                    for (int i = y; i < s.length() && !flag; i++) {
                        char c = s.charAt(i);
                        if (c == a || (a == '?' && (Character.isDigit(c) || Character.isLetter(c)))) flag = recur(x + 1, i + 1);
                    }
                }
            } else return false;
        }
        if (x == regex.length() && y == s.length()) flag = true;
        return flag;
    }
}
