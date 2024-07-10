// Given an array of integers arr.
//
// We want to select three indices i, j and k where (0 <= i < j <= k < arr.
// length).
//
// Let's define a and b as follows: 
//
// 
// a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] 
// b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k] 
// 
//
// Note that ^ denotes the bitwise-xor operation. 
//
// Return the number of triplets (i, j and k) Where a == b. 
//
// 
// Example 1: 
//
// 
// Input: arr = [2,3,1,6,7]
// Output: 4
// Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
// 
//
// Example 2: 
//
// 
// Input: arr = [1,1,1,1,1]
// Output: 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[i] <= 10⁸ 
// 
//
// 👍 235 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;1442
 * <p>
 * Name：Count Triplets That Can Form Two Arrays of Equal XOR
 *
 * @author Yuri
 * @since 2024-07-10 11:46:38
 */

public class CountTripletsThatCanFormTwoArraysOfEqualXor {

    public static void main(String[] args) {
        Solution solution = new CountTripletsThatCanFormTwoArraysOfEqualXor().new Solution();
        solution.countTriplets(new int[]{2, 3, 1, 6, 7});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * O(n)，官解讲的特别好，运用异或运算的性质可以将算法降低到O(n^2)，再用贡献法，可以把时间复杂度降低到O(n)
         *
         * @see tips/tips.md
         */
        public int countTriplets(int[] arr) {
            Map<Integer, Integer> sum = new HashMap<>(), count = new HashMap<>();
            int pre = 0, ans = 0;
            for (int k = 0; k < arr.length; k++) {
                sum.merge(pre, k, Integer::sum); // 先merge再计算是为了注入0
                count.merge(pre, 1, Integer::sum);
                pre ^= arr[k];
                if (sum.containsKey(pre)) ans += count.get(pre) * k - sum.get(pre);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}