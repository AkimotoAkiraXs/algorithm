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
         * I为朴素做法，因为除了目标数，其余数都会出现三次，所以统计所有数中每个位置1的总数量最后对3取余，就代表单独的数在该位置是否有1。
         */
        public int singleNumber_(int[] nums) {
            int k = 0;
            for (int i = 0; i < 32; i++) {
                int cnt = 0;
                for (int num : nums) cnt += num >> i & 1;
                k += cnt % 3 << i;
            }
            return k;
        }

        /**
         * II：从I中可以得到启示，每位上数字都是0->1->2->0->...我们用两位bit(a,b)来表示某一位数的变化，
         * 则变化规则为：(0,0)->(0,1)->(1,0)->(0,0)->(0,1)->(1,0)->...
         * <p>
         * ∴ a，b的状态可以分别表示为a = (a ^ num) & (a | b)，b = (b ^ num) & ~c
         * <p>
         * 由于位运算具有「并行计算」的特点，上述运算规则对于多位bit的数num也同样适用
         * <p>
         * 因为题目中只含有出现三次或者出现一次的数，出现三次的数最终影响都会积累在a，出现一次的数最终会记录为b，所以b就是所求答案
         * <p>
         * III：此为优化代码，先求b，因为只有(0,0)->(0,1)的过程a不能做异或运算，也只有(0,1)中，b（变更后）为1，所以当求得的b为1，则赋值
         * a为0，否则做异或。
         */
        public int singleNumber_II(int[] nums) {
            int a = 0, b = 0, c;
            for (int num : nums) {
                c = a;
                a = (a ^ num) & (a | b);
                b = (b ^ num) & ~c;
            }
            return b;
        }

        public int singleNumber_III(int[] nums) {
            int a = 0, b = 0;
            for (int num : nums) {
                b = (b ^ num) & ~a;
                a = (a ^ num) & ~b;
            }
            return b;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}