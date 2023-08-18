package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1170 <br/>
 * Name：Compare Strings by Frequency of the Smallest Character <br/>
 *
 * @author Yuri
 * @since 2023-06-10 06:58:18
 */

public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public static void main(String[] args) {
        Solution solution = new CompareStringsByFrequencyOfTheSmallestCharacter().new Solution();
        solution.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int wn = words.length;
            int[] wordCounts = new int[11];
            int[] preSum = new int[11];
            for (String word : words) wordCounts[f(word)]++;
            for (int i = 9; i >= 1; i--) preSum[i] += preSum[i + 1] + wordCounts[i + 1];
            int qn = queries.length;
            int[] ans = new int[qn];
            for (int i = 0; i < qn; i++) ans[i] = preSum[f(queries[i])];
            return ans;
        }

        // 不要用Java8!
        public int f(String s) {
            int cnt = 0;
            char ch = 'z';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < ch) {
                    ch = c;
                    cnt = 1;
                } else if (c == ch) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
