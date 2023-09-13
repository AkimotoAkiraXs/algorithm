// You are given a string s of length n containing only four kinds of characters:
// 'Q', 'W', 'E', and 'R'. 
//
// A string is said to be balanced if each of its characters appears n / 4 
// times where n is the length of the string.
//
// Return the minimum length of the substring that can be replaced with any 
// other string of the same length to make s balanced. If s is already balanced,
// return 0.
//
// 
// Example 1: 
//
// 
// Input: s = "QWER"
// Output: 0
// Explanation: s is already balanced.
// 
//
// Example 2: 
//
// 
// Input: s = "QQWE"
// Output: 1
// Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is
// balanced.
// 
//
// Example 3: 
//
// 
// Input: s = "QQQW"
// Output: 2
// Explanation: We can replace the first "QQ" to "ER".
// 
//
// 
// Constraints: 
//
// 
// n == s.length 
// 4 <= n <= 10⁵ 
// n is a multiple of 4. 
// s contains only 'Q', 'W', 'E', and 'R'. 
// 
//
// 👍 254 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;1234
 * <p>
 * Name：Replace the Substring for Balanced String
 *
 * @author Yuri
 * @since 2023-09-13 15:58:56
 */

public class ReplaceTheSubstringForBalancedString {
    public static void main(String[] args) {
        Solution solution = new ReplaceTheSubstringForBalancedString().new Solution();
        solution.balancedString("QQWE");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 灵神代码：反向思维，计算不用替换字符串内每个字符串不超过sum/4则是符合要求的情况
         */
        public int balancedString_(String S) {
            var s = S.toCharArray();
            var cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
            for (var c : s) ++cnt[c];
            int n = s.length, m = n / 4;
            if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) return 0; // 已经符合要求啦
            int ans = n, left = 0;
            for (int right = 0; right < n; right++) { // 枚举子串右端点
                --cnt[s[right]];
                while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                    ans = Math.min(ans, right - left + 1);
                    ++cnt[s[left++]]; // 缩小子串
                }
            }
            return ans;
        }


        /**
         * 计数，先统计每个字符出现次数，得出被替换子串中每个字符出现的最少次数，然后滑动窗口计算
         */
        public int balancedString(String s) {
            int[] keys = {'Q', 'W', 'E', 'R'};
            int n = s.length();
            int target = n / 4;
            Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Integer, Long> hash = new HashMap<>();
            for (int key : keys) {
                map.merge(key, 0L, Long::sum);
                hash.merge(key, 0L, Long::sum);
            }
            map.entrySet().forEach(o -> o.setValue(o.getValue() - target));
            if (map.values().stream().allMatch(o -> o <= 0)) return 0;

            int l = 0;
            int min = Integer.MAX_VALUE;
            for (int r = 0; r < n; r++) {
                int rKey = s.charAt(r);
                hash.merge(rKey, 1L, Long::sum);
                while (map.entrySet().stream().allMatch(o -> hash.get(o.getKey()) >= o.getValue())) {
                    min = Math.min(min, r - l + 1);
                    int lKey = s.charAt(l++);
                    hash.merge(lKey, -1L, Long::sum);
                }
            }
            return min;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}