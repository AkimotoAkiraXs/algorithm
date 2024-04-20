// 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s1 = "ab" s2 = "eidbaooo"
// 输出：true
// 解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
// 输入：s1= "ab" s2 = "eidboaoo"
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 449 👎 0


/*
 * Id：567
 * Name：字符串的排列
 * Date：2021-09-28 16:32:56
 */
package problems.leetcode.editor.cn;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 双指针，相较于滑动窗口思路较难。
         * 初始统计s1每个字母数量，定其为负值。
         * 循环s2，在位置r时，保证cnt[s2[r]]为0，否则移动左指针，如此一来就保证了在l~r位置内的元素一定是在s1内，此时看l~r长度是否为n即可。
         */
        public boolean checkInclusion(String s1, String s2) {
            int[] cnt = new int['z' + 1];
            for (Character c : s1.toCharArray()) cnt[c]--;
            int l = 0;
            for (int r = 0; r < s2.length(); r++) {
                char c = s2.charAt(r);
                cnt[c]++;
                while (cnt[c] > 0) cnt[s2.charAt(l++)]--;
                if (r - l + 1 == s1.length()) return true;
            }
            return false;
        }

        // 滑动窗口，直接统计不一样字母的数量，优化了每次循环的26个字母的比较耗时
        public boolean checkInclusion_(String s1, String s2) {
            int[] cnt = new int['z' + 1];
            int dif = 0;
            for (Character c : s1.toCharArray()) {
                if (cnt[c] == 0) dif++;
                cnt[c]--;
            }
            int k = s1.length();
            int l = 0;
            char[] cs2 = s2.toCharArray();
            for (int r = 0; r < cs2.length; r++) {
                char c = cs2[r];
                cnt[c]++;
                if (cnt[c] == 1) dif++;
                else if (cnt[c] == 0) dif--;
                if (r - l >= k) {
                    cnt[cs2[l]]--;
                    if (cnt[cs2[l]] == -1) dif++;
                    else if (cnt[cs2[l]] == 0) dif--;
                    l++;
                }
                if (dif == 0) return true;
            }
            return false;
        }

        // 滑动窗口，每次比较26个字母的数量是否一样
        public boolean checkInclusion_normal(String s1, String s2) {
            int[] cnt1 = new int['z' + 1];
            int[] cnt2 = new int['z' + 1];
            for (Character c : s1.toCharArray()) cnt1[c]++;
            int k = s1.length();
            int l = 0;
            char[] cs2 = s2.toCharArray();
            out:
            for (int r = 0; r < cs2.length; r++) {
                cnt2[cs2[r]]++;
                if (r - l >= k) cnt2[cs2[l++]]--;
                if (r - l + 1 == k) {
                    for (int i = 'a'; i <= 'z'; i++)
                        if (cnt1[i] != cnt2[i]) continue out;
                    return true;
                }
            }
            return false;
        }

        /**
         * 最开始的垃圾做法，以s1长度为一个窗口在s2滑动，但是最后的比较是以对s1、s2子串排序比较来求结果，所以很慢
         */
        public boolean checkInclusion_2021(String s1, String s2) {
            int length = s1.length();
            char[] chars1 = s1.toCharArray();
            Arrays.sort(chars1);
            int a = 0, b = length;
            while (b <= s2.length()) {
                String str = s2.substring(a, b);
                char[] chars2 = str.toCharArray();
                Arrays.sort(chars2);
                if (Arrays.equals(chars1, chars2)) {
                    return true;
                }
                a++;
                b++;
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
} 