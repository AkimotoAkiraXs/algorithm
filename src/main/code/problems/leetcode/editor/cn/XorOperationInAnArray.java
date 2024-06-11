// You are given an integer n and an integer start.
//
// Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.
// length.
//
// Return the bitwise XOR of all elements of nums. 
//
// 
// Example 1: 
//
// 
// Input: n = 5, start = 0
// Output: 8
// Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8)
//= 8.
// Where "^" corresponds to bitwise XOR operator.
// 
//
// Example 2: 
//
// 
// Input: n = 4, start = 3
// Output: 8
// Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 0 <= start <= 1000 
// n == nums.length 
// 
//
// 👍 148 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1486
 * <p>
 * Name：XOR Operation in an Array
 *
 * @author Yuri
 * @since 2024-06-07 17:47:12
 */

public class XorOperationInAnArray {

    public static void main(String[] args) {
        Solution solution = new XorOperationInAnArray().new Solution();
        solution.xorOperation(5, 0);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 数学：利用1⊕2⊕3=0得一般性公式4i⊕(4i+1)⊕(4i+2)⊕(4i+3)=0
         *
         * @see <a href="https://leetcode.cn/problems/xor-operation-in-an-array/solutions/762179/gong-shui-san-xie-yi-ti-shuang-jie-mo-ni-dggg/">【宫水三叶】一题双解 :「模拟」&「数学」</a>
         */
        public int xorOperation(int n, int start) {
            int k = start >> 1; // 因为原式都是+2，所以将其统一左移一位，变为符合公式的格式，计算除最低位外的求值
            int pre = cal(k - 1) ^ cal(k + n - 1); // a ⊕ (a+1) ⊕ ... ⊕ (a+n-1) = (1 ⊕ 2 ⊕ ... ⊕ (a+n-1)) ⊕ (1 ⊕ 2 ⊕ ... ⊕ (a-1))，简单来说1~n⊕1~k就得到了k+1~n
            int last = n & start & 1; // 最低位单独计算
            return pre << 1 | last;
        }

        private int cal(int x) {
            return switch (x % 4) {
                case 0 -> x;
                case 1 -> 1; // n^(n+1) = 1, x = n+1
                case 2 -> x + 1; // n^(n+1)^(n+2) = x+ 1, x=n+2
                default -> 0;
            };
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}