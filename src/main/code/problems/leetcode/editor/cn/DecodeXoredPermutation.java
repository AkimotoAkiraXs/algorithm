// There is an integer array perm that is a permutation of the first n positive
// integers, where n is always odd.
//
// It was encoded into another integer array encoded of length n - 1, such that 
// encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then
// encoded = [2,1].
//
// Given the encoded array, return the original array perm. It is guaranteed 
// that the answer exists and is unique.
//
// 
// Example 1: 
//
// 
// Input: encoded = [3,1]
// Output: [1,2,3]
// Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]
// 
//
// Example 2: 
//
// 
// Input: encoded = [6,5,4,6]
// Output: [2,4,1,5,3]
// 
//
// 
// Constraints: 
//
// 
// 3 <= n < 10⁵ 
// n is odd. 
// encoded.length == n - 1 
// 
//
// 👍 176 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1734
 * <p>
 * Name：Decode XORed Permutation
 *
 * @author Yuri
 * @since 2024-07-12 17:26:48
 */

public class DecodeXoredPermutation {

    public static void main(String[] args) {
        Solution solution = new DecodeXoredPermutation().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * encode转变为ans：encode[1] ⊕ ... ⊕ encode[n-2] = ans[1] ⊕ ans[2] ⊕ ans[2] ⊕ ans[3] ... ans[n-3] ⊕ ans[n-2] ⊕ ans[n-2] ⊕ ans[n-1]、
         * ∵ n是奇数所以，encode中个数为偶数，我们对encode从0开始隔一个数进行异或得到：a[1] ⊕ a[2] ⊕ ... ⊕  a[n-2]
         * 又∵ans中为1~n，所以对1~n进行异或再与上面的值异或就得到了a[n-1]
         */
        public int[] decode(int[] encoded) {
            int n = encoded.length + 1;
            int k = 0;
            for (int i = 0; i < n - 1; i += 2) k ^= encoded[i];
            for (int i = 1; i <= n; i++) k ^= i;
            int[] ans = new int[n];
            ans[n - 1] = k;
            for (int i = n - 2; i >= 0; i--) ans[i] = ans[i + 1] ^ encoded[i];
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}