// You're given strings jewels representing the types of stones that are jewels,
// and stones representing the stones you have. Each character in stones is a type
// of stone you have. You want to know how many of the stones you have are also
// jewels.
//
// Letters are case sensitive, so "a" is considered a different type of stone 
// from "A".
//
// 
// Example 1: 
// Input: jewels = "aA", stones = "aAAbbbb"
// Output: 3
// 
// Example 2: 
// Input: jewels = "z", stones = "ZZ"
// Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= jewels.length, stones.length <= 50 
// jewels and stones consist of only English letters. 
// All the characters of jewels are unique. 
// 
//
// 👍 777 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;771
 * <p>
 * Name：Jewels and Stones
 *
 * @author Yuri
 * @since 2023-07-24 19:17:07
 */


public class JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 位运算（hash暴力解忽略）
        public int numJewelsInStones(String jewels, String stones) {
            long i =0;
            int res = 0;
            for (Character c : jewels.toCharArray()) {
                int j = c - 'A';
                i |= 1L << j;
            }
            for (Character c : stones.toCharArray()) {
                int j = c - 'A';
                res += i >> j & 1;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
