// You are given a binary string s, and a 2D integer array queries where queries[
// i] = [firsti, secondi].
//
// For the iᵗʰ query, find the shortest substring of s whose decimal value, val,
// yields secondi when bitwise XORed with firsti. In other words, val ^ firsti == 
// secondi.
//
// The answer to the iᵗʰ query is the endpoints (0-indexed) of the substring [
// lefti, righti] or [-1, -1] if no such substring exists. If there are multiple
// answers, choose the one with the minimum lefti.
//
// Return an array ans where ans[i] = [lefti, righti] is the answer to the iᵗʰ 
// query.
//
// A substring is a contiguous non-empty sequence of characters within a string.
// 
//
// 
// Example 1: 
//
// 
// Input: s = "101101", queries = [[0,5],[1,2]]
// Output: [[0,2],[2,3]]
// Explanation: For the first query the substring in range [0,2] is "101" which
// has a decimal value of 5, and 5 ^ 0 = 5, hence the answer to the first query is [
// 0,2]. In the second query, the substring in range [2,3] is "11", and has a
// decimal value of 3, and 3 ^ 1 = 2. So, [2,3] is returned for the second query.
//
// 
//
// Example 2: 
//
// 
// Input: s = "0101", queries = [[12,8]]
// Output: [[-1,-1]]
// Explanation: In this example there is no substring that answers the query,
// hence [-1,-1] is returned.
// 
//
// Example 3: 
//
// 
// Input: s = "1", queries = [[4,5]]
// Output: [[0,0]]
// Explanation: For this example, the substring in range [0,0] has a decimal
// value of 1, and 1 ^ 4 = 5. So, the answer is [0,0].
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s[i] is either '0' or '1'. 
// 1 <= queries.length <= 10⁵ 
// 0 <= firsti, secondi <= 10⁹ 
// 
//
// 👍 27 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Id：&emsp;&emsp;2564
 * <p>
 * Name：Substring XOR Queries
 *
 * @author Yuri
 * @since 2024-07-12 15:05:58
 */

public class SubstringXorQueries {

    public static void main(String[] args) {
        Solution solution = new SubstringXorQueries().new Solution();
        System.out.println(Arrays.deepToString(solution.substringXorQueries("001000010111100100000100011100110010",
            new int[][]{{5, 18231}, {6, 132}, {4, 54}, {5, 2363849}, {1, 3088527}, {3, 126895921}})));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] substringXorQueries(String s, int[][] queries) {
            int n = queries.length;
            int[][] ans = new int[n][2];
            Arrays.fill(ans, new int[]{-1, -1});
            Map<Integer, List<Integer>> hash = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int key = queries[i][0] ^ queries[i][1];
                hash.putIfAbsent(key, new ArrayList<>()); // 不能用computeIfAbsent()，不然会超内存
                hash.get(key).add(i);
            }
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                int k = 0;
                for (int j = i; j < Math.min(cs.length, i + 30); j++) {
                    k = (k << 1) | (cs[j] - '0');
                    if (hash.containsKey(k)) {
                        List<Integer> list = hash.get(k);
                        for (int index : list) ans[index] = new int[]{i, j};
                        hash.remove(k);
                    }
                    if (k == 0) break;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}