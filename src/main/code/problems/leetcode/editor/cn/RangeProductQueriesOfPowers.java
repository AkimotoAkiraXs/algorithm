// Given a positive integer n, there exists a 0-indexed array called powers,
// composed of the minimum number of powers of 2 that sum to n. The array is sorted in
// non-decreasing order, and there is only one way to form the array.
//
// You are also given a 0-indexed 2D integer array queries, where queries[i] = [
// lefti, righti]. Each queries[i] represents a query where you have to find the
// product of all powers[j] with lefti <= j <= righti.
//
// Return an array answers, equal in length to queries, where answers[i] is the 
// answer to the iᵗʰ query. Since the answer to the iᵗʰ query may be too large,
// each answers[i] should be returned modulo 10⁹ + 7.
//
// 
// Example 1: 
//
// 
// Input: n = 15, queries = [[0,1],[2,2],[0,3]]
// Output: [2,4,64]
// Explanation:
// For n = 15, powers = [1,2,4,8]. It can be shown that powers cannot be a
// smaller size.
// Answer to 1st query: powers[0] * powers[1] = 1 * 2 = 2.
// Answer to 2nd query: powers[2] = 4.
// Answer to 3rd query: powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4
// * 8 = 64.
// Each answer modulo 10⁹ + 7 yields the same answer, so [2,4,64] is returned.
// 
//
// Example 2: 
//
// 
// Input: n = 2, queries = [[0,0]]
// Output: [2]
// Explanation:
// For n = 2, powers = [2].
// The answer to the only query is powers[0] = 2. The answer modulo 10⁹ + 7 is
// the same, so [2] is returned.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 1 <= queries.length <= 10⁵ 
// 0 <= starti <= endi < powers.length 
// 
//
// 👍 20 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2438
 * <p>
 * Name：Range Product Queries of Powers
 *
 * @author Yuri
 * @since 2024-08-08 15:12:22
 */

public class RangeProductQueriesOfPowers {

    public static void main(String[] args) {
        Solution solution = new RangeProductQueriesOfPowers().new Solution();
        solution.productQueries(806335498, new int[][]{{1, 8}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] productQueries(int n, int[][] queries) {
            int mod = (int) 1e9 + 7;
            int len = Integer.bitCount(n);
            int[] power = new int[len];
            for (int i = 0; i < len; i++) {
                power[i] = Integer.numberOfTrailingZeros(n);
                n &= n - 1;
            }
            int[] pre = new int[len + 1];
            for (int i = 0; i < len; i++)
                pre[i + 1] = pre[i] + power[i];
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int k = pre[queries[i][1] + 1] - pre[queries[i][0]];
                long record = 1;
                while (k > 30) {
                    record = record * (1 << 30) % mod;
                    k -= 30;
                }
                ans[i] = (int) (record * (1 << k) % mod);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}