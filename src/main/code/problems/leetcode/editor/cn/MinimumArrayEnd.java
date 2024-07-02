// You are given two integers n and x. You have to construct an array of
// positive integers nums of size n where for every 0 <= i < n - 1, nums[i + 1] is greater
// than nums[i], and the result of the bitwise AND operation between all elements
// of nums is x.
//
// Return the minimum possible value of nums[n - 1]. 
//
// 
// Example 1: 
//
// 
// Input: n = 3, x = 4 
// 
//
// Output: 6 
//
// Explanation: 
//
// nums can be [4,5,6] and its last element is 6. 
//
// Example 2: 
//
// 
// Input: n = 2, x = 7 
// 
//
// Output: 15 
//
// Explanation: 
//
// nums can be [7,15] and its last element is 15. 
//
// 
// Constraints: 
//
// 
// 1 <= n, x <= 10⁸ 
// 
//
// 👍 11 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;3133
 * <p>
 * Name：Minimum Array End
 *
 * @author Yuri
 * @since 2024-07-02 16:09:01
 */

public class MinimumArrayEnd {

    public static void main(String[] args) {
        Solution solution = new MinimumArrayEnd().new Solution();
        System.out.println(solution.minEnd(3, 4));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 其实就是用n-1（减去x本身）来组成二进制插入到x中0的位置
        public long minEnd(int n, int x) {
            n--;
            long res = x;
            int t = 0;
            while (n > 0) {
                while ((res >> t & 1) == 1) t++;
                if ((n & 1) == 1) res |= 1L << t;
                n >>= 1;
                t++;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}