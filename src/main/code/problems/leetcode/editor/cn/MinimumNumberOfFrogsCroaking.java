// You are given the string croakOfFrogs, which represents a combination of the 
// string "croak" from different frogs, that is, multiple frogs can croak at the 
// same time, so multiple "croak" are mixed. 
//
// Return the minimum number of different frogs to finish all the croaks in the 
// given string. 
//
// A valid "croak" means a frog is printing five letters 'c', 'r', 'o', 'a', 
// and 'k' sequentially. The frogs have to print all five letters to finish a croak. 
// If the given string is not a combination of a valid "croak" return -1. 
//
// 
// Example 1: 
//
// 
// Input: croakOfFrogs = "croakcroak"
// Output: 1 
// Explanation: One frog yelling "croak" twice.
// 
//
// Example 2: 
//
// 
// Input: croakOfFrogs = "crcoakroak"
// Output: 2 
// Explanation: The minimum number of frogs is two. 
// The first frog could yell "crcoakroak".
// The second frog could yell later "crcoakroak".
// 
//
// Example 3: 
//
// 
// Input: croakOfFrogs = "croakcrook"
// Output: -1
// Explanation: The given string is an invalid combination of "croak" from 
// different frogs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= croakOfFrogs.length <= 10⁵ 
// croakOfFrogs is either 'c', 'r', 'o', 'a', or 'k'. 
// 
//
// Related Topics 字符串 计数 👍 161 👎 0

package problems.leetcode.editor.cn;

import java.util.*;

/**
 * Id：&emsp;&emsp;1419
 * <p>
 * Name：Minimum Number of Frogs Croaking
 *
 * @author Yuri
 * @since 2023-05-06 18:39:11
 */


public class MinimumNumberOfFrogsCroaking {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfFrogsCroaking().new Solution();
        solution.minNumberOfFrogs("croakcroak");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            Map<Character, Integer> map = new HashMap<>();
            int cnt = 0, ct = 0;
            int ans = Integer.MIN_VALUE;
            for (Character c : croakOfFrogs.toCharArray()) {
                if (c == 'c') {
                    ans = Math.max(++cnt, ans);
                    ct++;
                } else if ((c == 'r' && Objects.equals(map.get('c'), map.get(c)))
                        || (c == 'o' && Objects.equals(map.get('r'), map.get(c)))
                        || (c == 'a' && Objects.equals(map.get('o'), map.get(c)))
                        || (c == 'k' && Objects.equals(map.get('a'), map.get(c)))) {
                    return -1;
                } else if (c == 'k') --cnt;
                else if (c != 'r' && c != 'o' && c != 'a') return -1;
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            // 统计每个字母出现相同次数，保证蛙叫了完整的一声
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (ct != entry.getValue()) return -1;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
