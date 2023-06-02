// You are given a 0-indexed array of strings words and a 2D array of integers
// queries.
//
// Each query queries[i] = [li, ri] asks us to find the number of strings 
// present in the range li to ri (both inclusive) of words that start and end with a
// vowel.
//
// Return an array ans of size queries.length, where ans[i] is the answer to 
// the iᵗʰ query.
//
// Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'. 
//
// 
// Example 1: 
//
// 
// Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
// Output: [2,3,0]
// Explanation: The strings starting and ending with a vowel are "aba", "ece",
//"aa" and "e".
// The answer to the query [0,2] is 2 (strings "aba" and "ece").
// to query [1,4] is 3 (strings "ece", "aa", "e").
// to query [1,1] is 0.
// We return [2,3,0].
// 
//
// Example 2: 
//
// 
// Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
// Output: [3,2,1]
// Explanation: Every string satisfies the conditions, so we return [3,2,1].
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁵ 
// 1 <= words[i].length <= 40 
// words[i] consists only of lowercase English letters. 
// sum(words[i].length) <= 3 * 10⁵ 
// 1 <= queries.length <= 10⁵ 
// 0 <= li <= ri < words.length 
// 
//
// Related Topics 数组 字符串 前缀和 👍 35 👎 0

package leetcode.editor.cn;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;2559
 * <p>
 * Name：Count Vowel Strings in Ranges
 *
 * @author Yuri
 * @since 2023-06-02 10:27:31
 */


public class CountVowelStringsInRanges {
    public static void main(String[] args) {
        Solution solution = new CountVowelStringsInRanges().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            Set<Character> hash = Stream.of('a', 'e', 'i', 'o', 'u').collect(Collectors.toSet()); // hash会比别人慢几秒
            int[] prefixSum = new int[words.length + 1];
            prefixSum[0] = 0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (hash.contains(word.charAt(0)) && hash.contains(word.charAt(word.length() - 1))) {
                    prefixSum[i + 1] = prefixSum[i] + 1;
                } else prefixSum[i + 1] = prefixSum[i];
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                res[i] = prefixSum[query[1] + 1] - prefixSum[query[0]];
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
