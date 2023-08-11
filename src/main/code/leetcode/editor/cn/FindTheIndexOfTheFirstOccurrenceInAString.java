package leetcode.editor.cn;

import org.checkerframework.checker.units.qual.s;

import java.util.stream.IntStream;

/**
 * Id：&emsp;&emsp;28
 * <p>
 * Name：找出字符串中第一个匹配项的下标
 *
 * @author Yuri
 * @since 2023-02-12 04:44:33
 */

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            int[] next = getNext(needle);
            int k = -1;

            for (int i = 0; i < haystack.length(); i++) {
                while (k > -1 && needle.charAt(k + 1) != haystack.charAt(i)) k = next[k];
                if (needle.charAt(k + 1) == haystack.charAt(i)) k++;
                if (k == needle.length() - 1) return i - needle.length() + 1;
            }
            return -1;
        }

        public int[] getNext(String match) {
            char[] chars = match.toCharArray();
            int[] next = new int[match.length()];
            next[0] = -1;
            int k = -1;

            for (int i = 1; i < next.length; i++) {
                while (k > -1 && chars[k + 1] != chars[i]) k = next[k];
                if (chars[k + 1] == chars[i]) k++;
                next[i] = k;
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
