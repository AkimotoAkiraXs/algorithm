//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 898 👎 0


package problems.leetcode.editor.cn;

import java.util.*;

/**
 * Id：&emsp;&emsp;438
 * <p>
 * Name：找到字符串中所有字母异位词
 *
 * @author Yuri
 * @since 2022-05-26 16:45:05
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams.toString());
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 双指针
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int[] cnt = new int['z' + 1];
            for (Character c : p.toCharArray()) cnt[c]--;
            int l = 0;
            for (int r = 0; r < s.length(); r++) {
                cnt[s.charAt(r)]++;
                while (cnt[s.charAt(r)] > 0) cnt[s.charAt(l++)]--;
                if (r - l + 1 == p.length()) res.add(l);
            }
            return res;
        }

        public List<Integer> findAnagrams_slidingWindows(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int[] cnt = new int['z' + 1];
            int dif = 0;
            for (Character c : p.toCharArray()) {
                if (cnt[c] == 0) dif++;
                cnt[c]--;
            }
            int l = 0;
            for (int r = 0; r < s.length(); r++) {
                char c = s.charAt(r);
                cnt[c]++;
                if (cnt[c] == 0) dif--;
                else if (cnt[c] == 1) dif++;
                if (r - l >= p.length()){
                    char cc = s.charAt(l);
                    cnt[cc]--;
                    if (cnt[cc] == 0) dif--;
                    else if (cnt[cc] == -1) dif++;
                    l++;
                }
                if (dif == 0) res.add(l);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}