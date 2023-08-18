// Given a string s which consists of lowercase or uppercase letters, return the
// length of the longest palindrome that can be built with those letters.
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome 
// here.
//
// 
// Example 1: 
//
// 
// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose
// length is 7.
// 
//
// Example 2: 
//
// 
// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is
// 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2000 
// s consists of lowercase and/or uppercase English letters only. 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 529 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;409
 * <p>
 * Name：Longest Palindrome
 *
 * @author Yuri
 * @since 2023-04-27 11:41:27
 */


public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            // 也可以用Set筛，但Java8比较优雅
            AtomicInteger atom = new AtomicInteger(0);
            Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .forEach((key, value) -> {
                        if ((value & 1) == 0) atom.addAndGet(value.intValue());
                        else atom.addAndGet(value.intValue() - 1);
                    });
            int res = atom.get();
            return res == s.length() ? res : res + 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
