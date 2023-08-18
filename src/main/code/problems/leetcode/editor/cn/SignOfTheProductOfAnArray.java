//已知函数 signFunc(x) 将会根据 x 的正负返回特定值： 
//
// 
// 如果 x 是正数，返回 1 。 
// 如果 x 是负数，返回 -1 。 
// 如果 x 是等于 0 ，返回 0 。 
// 
//
// 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。 
//
// 返回 signFunc(product) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,-2,-3,-4,3,2,1]
//输出：1
//解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,5,0,2,-3]
//输出：0
//解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,1,-1,1,-1]
//输出：-1
//解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 数组 数学 👍 54 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1822
 * <p>
 * Name：数组元素积的符号
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class SignOfTheProductOfAnArray {
    public static void main(String[] args) {
        Solution solution = new SignOfTheProductOfAnArray().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arraySign(int[] nums) {
            int res = 1;
            for (int num : nums) {
                if (num == 0) return 0;
                if (num < 0) res = -res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}