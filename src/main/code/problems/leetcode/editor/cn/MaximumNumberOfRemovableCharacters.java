// You are given two strings s and p where p is a subsequence of s. You are also
// given a distinct 0-indexed integer array removable containing a subset of
// indices of s (s is also 0-indexed).
//
// You want to choose an integer k (0 <= k <= removable.length) such that, 
// after removing k characters from s using the first k indices in removable, p is
// still a subsequence of s. More formally, you will mark the character at s[removable[
// i]] for each 0 <= i < k, then remove all marked characters and check if p is
// still a subsequence.
//
// Return the maximum k you can choose such that p is still a subsequence of s 
// after the removals.
//
// A subsequence of a string is a new string generated from the original string 
// with some characters (can be none) deleted without changing the relative order
// of the remaining characters.
//
// 
// Example 1: 
//
// 
// Input: s = "abcacb", p = "ab", removable = [3,1,0]
// Output: 2
// Explanation: After removing the characters at indices 3 and 1, "abcacb"
// becomes "accb".
//"ab" is a subsequence of "accb".
// If we remove the characters at indices 3, 1, and 0, "abcacb" becomes "ccb",
// and "ab" is no longer a subsequence.
// Hence, the maximum k is 2.
// 
//
// Example 2: 
//
// 
// Input: s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]
// Output: 1
// Explanation: After removing the character at index 3, "abcbddddd" becomes
//"abcddddd".
//"abcd" is a subsequence of "abcddddd".
// 
//
// Example 3: 
//
// 
// Input: s = "abcab", p = "abc", removable = [0,1,2,3,4]
// Output: 0
// Explanation: If you remove the first index in the array removable, "abc" is
// no longer a subsequence.
// 
//
// 
// Constraints: 
//
// 
// 1 <= p.length <= s.length <= 10⁵ 
// 0 <= removable.length < s.length 
// 0 <= removable[i] < s.length 
// p is a subsequence of s. 
// s and p both consist of lowercase English letters. 
// The elements in removable are distinct. 
// 
//
// 👍 69 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1898
 * <p>
 * Name：Maximum Number of Removable Characters
 *
 * @author Yuri
 * @since 2024-08-27 16:29:48
 */

public class MaximumNumberOfRemovableCharacters {

    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfRemovableCharacters().new Solution();
        System.out.println(solution.maximumRemovals("qlevcvgzfpryiqlwy", "qlecfqlw", new int[]{12, 5}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumRemovals(String s, String p, int[] removable) {
            char[] ss = s.toCharArray(), ps = p.toCharArray();
            int l = 0, r = removable.length;
            while (l <= r) {
                int m = l + r >> 1;
                boolean f = false;
                int[] ints = Arrays.stream(removable, 0, m).sorted().toArray();
                Arrays.sort(ints);
                for (int i = 0, j = 0, k = 0; i < ss.length; i++) {
                    if (k < m && ints[k] == i) k++;
                    else if (j < ps.length && ss[i] == ps[j] && ++j == ps.length) {
                        f = true;
                        break;
                    }
                }
                if (f) l = m + 1;
                else r = m - 1;
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}