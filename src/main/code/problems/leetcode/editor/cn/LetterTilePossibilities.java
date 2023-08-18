// You have n tiles, where each tile has one letter tiles[i] printed on it.
//
// Return the number of possible non-empty sequences of letters you can make 
// using the letters printed on those tiles.
//
// 
// Example 1: 
//
// 
// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB",
//"ABA", "BAA".
// 
//
// Example 2: 
//
// 
// Input: tiles = "AAABBC"
// Output: 188
// 
//
// Example 3: 
//
// 
// Input: tiles = "V"
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= tiles.length <= 7 
// tiles consists of uppercase English letters. 
// 
//
// Related Topics 哈希表 字符串 回溯 计数 👍 230 👎 0

package problems.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;1079
 * <p>
 * Name：Letter Tile Possibilities
 *
 * @author Yuri
 * @since 2023-05-19 18:57:08
 */


public class LetterTilePossibilities {
    public static void main(String[] args) {
        Solution solution = new LetterTilePossibilities().new Solution();
        solution.numTilePossibilities("AAB");

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTilePossibilities(String tiles) {
            Set<String> set = new HashSet<>();
            for (Character c : tiles.toCharArray()) {
                String s = String.valueOf(c);
                for (String str : new HashSet<>(set)) {
                    for (int i = 0; i <= str.length(); i++) {
                        StringBuilder sb = new StringBuilder(str);
                        set.add(sb.insert(i, c).toString());
                    }
                }
                set.add(s);
            }
            return set.size();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
