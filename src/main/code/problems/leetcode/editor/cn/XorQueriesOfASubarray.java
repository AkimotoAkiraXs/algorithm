// You are given an array arr of positive integers. You are also given the array
// queries where queries[i] = [lefti, righti].
//
// For each query i compute the XOR of elements from lefti to righti (that is, 
// arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
//
// Return an array answer where answer[i] is the answer to the iᵗʰ query. 
//
// 
// Example 1: 
//
// 
// Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
// Output: [2,7,14,8]
// Explanation:
// The binary representation of the elements in the array are:
// 1 = 0001
// 3 = 0011
// 4 = 0100
// 8 = 1000
// The XOR values for queries are:
//[0,1] = 1 xor 3 = 2 
//[1,2] = 3 xor 4 = 7 
//[0,3] = 1 xor 3 xor 4 xor 8 = 14 
//[3,3] = 8
// 
//
// Example 2: 
//
// 
// Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
// Output: [8,0,4,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length, queries.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 10⁹ 
// queries[i].length == 2 
// 0 <= lefti <= righti < arr.length 
// 
//
// 👍 169 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1310
 * <p>
 * Name：XOR Queries of a Subarray
 *
 * @author Yuri
 * @since 2024-07-05 18:09:27
 */

public class XorQueriesOfASubarray {

    public static void main(String[] args) {
        Solution solution = new XorQueriesOfASubarray().new Solution();
        solution.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{1, 2}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] xorQueries(int[] arr, int[][] queries) {
            int n = arr.length;
            int[] pre = new int[n + 1];
            for (int i = 1; i <= n; i++) pre[i] = pre[i - 1] ^ arr[i - 1];
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) ans[i] = pre[queries[i][0]] ^ pre[queries[i][1] + 1];
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}