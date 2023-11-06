// Given a string array words, return the maximum value of length(word[i]) *
// length(word[j]) where the two words do not share common letters. If no such two
// words exist, return 0.
//
// 
// Example 1: 
//
// 
// Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
// Output: 16
// Explanation: The two words can be "abcw", "xtfn".
// 
//
// Example 2: 
//
// 
// Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
// Output: 4
// Explanation: The two words can be "ab", "cd".
// 
//
// Example 3: 
//
// 
// Input: words = ["a","aa","aaa","aaaa"]
// Output: 0
// Explanation: No such pair of words.
// 
//
// 
// Constraints: 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] consists only of lowercase English letters. 
// 
//
// 👍 478 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Id：&emsp;&emsp;318
 * <p>
 * Name：Maximum Product of Word Lengths
 *
 * @author Yuri
 * @since 2023-11-06 16:45:37
 */

public class MaximumProductOfWordLengths {

    public static void main(String[] args) {
        Solution solution = new MaximumProductOfWordLengths().new Solution();
        solution.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(String[] words) {
            Arrays.sort(words, Comparator.comparing(String::length).reversed());
            int n = words.length, max = 0;
            int k;
            Set<Integer> hash = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String wordI = words[i];
                k = 0;
                for (Character c : wordI.toCharArray()) k |= 1 << (c - 'a');
                if (!hash.add(k)) continue; // 用hash记录词频k，词频相同则只需算一次最大那个词就行了
                label:
                for (int j = i + 1; j < n; j++) {
                    String wordJ = words[j];
                    for (Character c : wordJ.toCharArray())
                        if ((k >> (c - 'a') & 1) == 1) continue label;
                    max = Math.max(max, wordI.length() * wordJ.length());
                }
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}