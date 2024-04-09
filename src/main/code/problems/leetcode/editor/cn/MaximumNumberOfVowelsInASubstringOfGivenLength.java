//Given a string s and an integer k, return the maximum number of vowel letters 
//in any substring of s with length k. 
//
// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'. 
//
// 
// Example 1: 
//
// 
//Input: s = "abciiidef", k = 3
//Output: 3
//Explanation: The substring "iii" contains 3 vowel letters.
// 
//
// Example 2: 
//
// 
//Input: s = "aeiou", k = 2
//Output: 2
//Explanation: Any substring of length 2 contains 2 vowels.
// 
//
// Example 3: 
//
// 
//Input: s = "leetcode", k = 3
//Output: 2
//Explanation: "lee", "eet" and "ode" contain 2 vowels.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 1 <= k <= s.length 
// 
//
// 👍 94 👎 0

package problems.leetcode.editor.cn;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;1456
 * <p>
 * Name：Maximum Number of Vowels in a Substring of Given Length
 *
 * @author Yuri
 * @since 2024-04-08 18:26:58
 */

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfVowelsInASubstringOfGivenLength().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxVowels(String s, int k) {
            Set<Character> vowel = Stream.of('a', 'e', 'i', 'o', 'u').collect(Collectors.toSet());
            int l = 0;
            int cnt = 0;
            int max = 0;
            for (int r = 0; r < s.length(); r++) {
                if (vowel.contains(s.charAt(r))) cnt++;
                while (r - l >= k && vowel.contains(s.charAt(l++))) cnt--;
                max = Math.max(cnt, max);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}