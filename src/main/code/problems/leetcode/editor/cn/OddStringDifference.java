package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2451 <br/>
 * Name：Odd String Difference <br/>
 *
 * @author Yuri
 * @since 2023-05-25 20:56:32
 */

public class OddStringDifference {
    public static void main(String[] args) {
        Solution solution = new OddStringDifference().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String oddString(String[] words) {
            String same;
            String a = words[0];
            String b = words[1];
            String c = words[2];
            if (compare(a, b)) {
                for (int i = 2; i < words.length; i++) {
                    if (!compare(a, words[i])) return words[i];
                }
            } else {
                return compare(a, b) ? c : compare(a, c) ? b : a;
            }
            return null;
        }

        private boolean compare(String a, String b) {
            int gap = a.charAt(0) - b.charAt(0);
            int n = a.length();
            for (int i = 1; i < n; i++) {
                if (a.charAt(i) - b.charAt(i) != gap) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
