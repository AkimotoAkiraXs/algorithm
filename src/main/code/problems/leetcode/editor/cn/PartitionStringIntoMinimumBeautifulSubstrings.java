// Given a binary string s, partition the string into one or more substrings
// such that each substring is beautiful.
//
// A string is beautiful if: 
//
// 
// It doesn't contain leading zeros. 
// It's the binary representation of a number that is a power of 5. 
// 
//
// Return the minimum number of substrings in such partition. If it is 
// impossible to partition the string s into beautiful substrings, return -1.
//
// A substring is a contiguous sequence of characters in a string. 
//
// 
// Example 1: 
//
// 
// Input: s = "1011"
// Output: 2
// Explanation: We can paritition the given string into ["101", "1"].
//- The string "101" does not contain leading zeros and is the binary 
// representation of integer 5¹ = 5.
//- The string "1" does not contain leading zeros and is the binary 
// representation of integer 5⁰ = 1.
// It can be shown that 2 is the minimum number of beautiful substrings that s
// can be partitioned into.
// 
//
// Example 2: 
//
// 
// Input: s = "111"
// Output: 3
// Explanation: We can paritition the given string into ["1", "1", "1"].
//- The string "1" does not contain leading zeros and is the binary 
// representation of integer 5⁰ = 1.
// It can be shown that 3 is the minimum number of beautiful substrings that s
// can be partitioned into.
// 
//
// Example 3: 
//
// 
// Input: s = "0"
// Output: -1
// Explanation: We can not partition the given string into beautiful substrings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s[i] is either '0' or '1'. 
// 
//
// 👍 3 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Id：&emsp;&emsp;2767
 * <p>
 * Name：Partition String Into Minimum Beautiful Substrings
 *
 * @author Yuri
 * @since 2023-07-10 11:24:45
 */


public class PartitionStringIntoMinimumBeautifulSubstrings {
    public static void main(String[] args) {
        Solution solution = new PartitionStringIntoMinimumBeautifulSubstrings().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 因为n<=15，直接暴力也才2^15，所以也能过。这里是进行了预处理的记忆化搜索。
        Set<String> pow5;
        Map<String, Integer> hash;
        Integer[] len;

        public int minimumBeautifulSubstrings(String s) {
            int k = 1;
            pow5 = new HashSet<>();
            hash = new HashMap<>();
            for (int i = 0; i <= 7; i++) {
                pow5.add(Integer.toBinaryString(k));
                k *= 5;
            }
            len = pow5.stream().map(String::length).sorted().toArray(Integer[]::new);
            int ans = dfs(s);
            return ans > 15 ? -1 : ans;
        }

        int dfs(String s) {
            if (hash.containsKey(s)) return hash.get(s);// 可以把s用hash记下来，就变成记忆化搜索了
            if (pow5.contains(s)) return 1; // s搜到末端也就是最后一段，题目求能分成几段不是分割几次，所以这里返回1不是0
            int min = Integer.MAX_VALUE - 20; // 避免+1爆内存
            for (int num : len) {
                if (s.length() <= num) break;
                if (s.charAt(num) == '0') continue;
                if (!pow5.contains(s.substring(0, num))) continue;
                min = Math.min(min, dfs(s.substring(num)) + 1);
            }
            hash.put(s, min);
            return min;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
