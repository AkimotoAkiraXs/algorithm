// Given an integer array nums where every element appears three times except
// for one, which appears exactly once. Find the single element and return it.
//
// You must implement a solution with a linear runtime complexity and use only 
// constant extra space.
//
// 
// Example 1: 
// Input: nums = [2,2,3,2]
// Output: 3
// 
// Example 2: 
// Input: nums = [0,1,0,1,0,1,99]
// Output: 99
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// Each element in nums appears exactly three times except for one element 
// which appears once.
// 
//
// 👍 1149 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;137
 * <p>
 * Name：Single Number II
 *
 * @author Yuri
 * @see SingleNumber
 * @see SingleNumberIii
 * @since 2023-10-16 16:38:11
 */

public class SingleNumberIi {

    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * II：从I中可以得到启示，每位上数字都是0->1->2->0我们用两位bit(a,b)来表示某一位数的变化，
         * 则变化规则为：(0,0)->(0,1)->(1,0)->(0,0)所以出现三次的数都会变为0，出现一次的数会累积到b
         * <p>
         * 由于位运算具有「并行计算」的特点，上述运算规则对于多位bit的数num也同样适用
         */
        public int singleNumber_II(int[] nums) {
            int a = 0, b = 0;
            for (int num : nums) {
                b = (b ^ num) & ~a;
                a = (a ^ num) & ~b;
            }
            return b;
        }

        /**
         * 暴力：单独对每个bit位进行余3统计，结果相加
         */
        public int singleNumber_bf(int[] nums) {
            int k = 0;
            for (int i = 0; i < 32; i++) {
                int cnt = 0;
                for (int num : nums) cnt += num >> i & 1;
                k += cnt % 3 << i;
            }
            return k;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}