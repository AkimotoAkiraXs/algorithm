//You are given a string word and an integer k. 
//
// A substring s of word is complete if: 
//
// 
// Each character in s occurs exactly k times. 
// The difference between two adjacent characters is at most 2. That is, for 
//any two adjacent characters c1 and c2 in s, the absolute difference in their 
//positions in the alphabet is at most 2. 
// 
//
// Return the number of complete substrings of word. 
//
// A substring is a non-empty contiguous sequence of characters in a string. 
//
// 
// Example 1: 
//
// 
//Input: word = "igigee", k = 2
//Output: 3
//Explanation: The complete substrings where each character appears exactly 
//twice and the difference between adjacent characters is at most 2 are: igigee, 
//igigee, igigee.
// 
//
// Example 2: 
//
// 
//Input: word = "aaabbbccc", k = 3
//Output: 6
//Explanation: The complete substrings where each character appears exactly 
//three times and the difference between adjacent characters is at most 2 are: 
//aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc.
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 10⁵ 
// word consists only of lowercase English letters. 
// 1 <= k <= word.length 
// 
//
// 👍 32 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2953
 * <p>
 * Name：Count Complete Substrings
 *
 * @author Yuri
 * @since 2024-04-28 17:59:45
 */

public class CountCompleteSubstrings {
    public static void main(String[] args) {
        Solution solution = new CountCompleteSubstrings().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 分组定长滑动窗口，O(26n)
         * <p>
         * 根据左右字母相差<=2将word分为几个字符串，每个字符串分别模拟1~26*k固定长度的滑窗下能有几个满足条件的子串。
         * <p>
         * 此外，采用了记录cnt=k的个数来避免每次都去遍历26个字母，将复杂度从O(n26^2)缩小到了O(26n)
         */
        public int countCompleteSubstrings(String word, int k) {
            int n = word.length();
            int ans = 0;
            int r = 0;
            while (r < n) {
                int l = r;
                r++;
                while (r < n && Math.abs(word.charAt(r) - word.charAt(r - 1)) <= 2) r++;
                ans += f(word.substring(l, r), k);
            }
            return ans;
        }

        private int f(String S, int k) {
            char[] cs = S.toCharArray();
            int res = 0;
            for (int i = 1; i <= 26; i++) {
                if (i * k > cs.length) break;
                int t = 0; // t是统计cnt==k的字母数
                int[] cnt = new int['z' + 1];
                for (int r = 0; r < cs.length; r++) {
                    cnt[cs[r]]++;
                    if (cnt[cs[r]] == k) t++;
                    else if (cnt[cs[r]] == k + 1) t--;
                    int l = r - i * k + 1;
                    if (l >= 0) { // l>=0后窗口开始滑动
                        if (t == i) res++;
                        cnt[cs[l]]--;
                        if (cnt[cs[l]] == k) t++;
                        else if (cnt[cs[l]] == k - 1) t--;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}