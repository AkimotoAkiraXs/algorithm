// You are given an integer array pref of size n. Find and return the array arr
// of size n that satisfies:
//
// 
// pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]. 
// 
//
// Note that ^ denotes the bitwise-xor operation. 
//
// It can be proven that the answer is unique. 
//
// 
// Example 1: 
//
// 
// Input: pref = [5,2,0,3,1]
// Output: [5,7,2,3,2]
// Explanation: From the array [5,7,2,3,2] we have the following:
//- pref[0] = 5.
//- pref[1] = 5 ^ 7 = 2.
//- pref[2] = 5 ^ 7 ^ 2 = 0.
//- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
//- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
// 
//
// Example 2: 
//
// 
// Input: pref = [13]
// Output: [13]
// Explanation: We have pref[0] = arr[0] = 13.
// 
//
// 
// Constraints: 
//
// 
// 1 <= pref.length <= 10⁵ 
// 0 <= pref[i] <= 10⁶ 
// 
//
// 👍 24 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2433
 * <p>
 * Name：Find The Original Array of Prefix Xor
 *
 * @author Yuri
 * @since 2024-07-05 18:02:45
 */

public class FindTheOriginalArrayOfPrefixXor {

    public static void main(String[] args) {
        Solution solution = new FindTheOriginalArrayOfPrefixXor().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findArray(int[] pref) {
            int n = pref.length;
            int[] res = new int[n];
            res[0] = pref[0];
            for (int i = 1; i < n; i++) res[i] = pref[i - 1] ^ pref[i];
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}