// You are given a string s and array queries where queries[i] = [lefti, righti,
// ki]. We may rearrange the substring s[lefti...righti] for each query and then
// choose up to ki of them to replace with any lowercase English letter.
//
// If the substring is possible to be a palindrome string after the operations 
// above, the result of the query is true. Otherwise, the result is false.
//
// Return a boolean array answer where answer[i] is the result of the iᵗʰ query 
// queries[i].
//
// Note that each letter is counted individually for replacement, so if, for 
// example s[lefti...righti] = "aaa", and ki = 2, we can only replace two of the
// letters. Also, note that no query modifies the initial string s.
//
// 
// Example : 
//
// 
// Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
// Output: [true,false,false,true,true]
// Explanation:
// queries[0]: substring = "d", is palidrome.
// queries[1]: substring = "bc", is not palidrome.
// queries[2]: substring = "abcd", is not palidrome after replacing only 1
// character.
// queries[3]: substring = "abcd", could be changed to "abba" which is palidrome.
// Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" 
// with "ab".
// queries[4]: substring = "abcda", could be changed to "abcba" which is
// palidrome.
// 
//
// Example 2: 
//
// 
// Input: s = "lyb", queries = [[0,1,0],[2,2,1]]
// Output: [false,true]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, queries.length <= 10⁵ 
// 0 <= lefti <= righti < s.length 
// 0 <= ki <= s.length 
// s consists of lowercase English letters. 
// 
//
// Related Topics 位运算 数组 哈希表 字符串 前缀和 👍 110 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;1177
 * <p>
 * Name：Can Make Palindrome from Substring
 *
 * @author Yuri
 * @since 2023-06-15 09:49:07
 */


public class CanMakePalindromeFromSubstring {
    public static void main(String[] args) {
        Solution solution = new CanMakePalindromeFromSubstring().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 因为字母可以任意顺序，所以字母的偶数次时总是可以互相回文无需修改。
         * 当某个字母是奇数次时，我们把其多的那个奇数次字母命名为落单字母（很容易想到对于每个字母落单字母数最多为1）。
         * 此时如果子串长度为奇数，那么这个落单字母可以放在最中间也构成回文。
         * 如果子串长度为偶数，那么落单字母数也不可能为奇数，必然存在另一个落单字母，此时只需要修改一次即可构成回文。
         * <p>
         * 从上述推论可以得出修改最小次数即为：落单字母数（奇数则-1） / 2。
         * <p>
         * 我们用二进制位记录a~z的奇偶性，0表示偶，1表示奇，用异或进行遍历记录，得到需要前缀和数组。
         * 对于所求的子字符串，只需利用 前缀和+异或 即可得到其落单字母数，除以2则可得到变为回文串所需最少次数。
         */
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int n = s.length();
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                char c = s.charAt(i - 1);
                int bit = 1 << (c - 'a');
                preSum[i] = preSum[i - 1] ^ bit;
            }
            List<Boolean> ans = new ArrayList<>(queries.length);
            for (int[] query : queries) {
                int r = query[0], l = query[1], num = query[2];
                boolean flag = Integer.bitCount(preSum[l + 1] ^ preSum[r]) / 2 <= num;
                ans.add(flag);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
