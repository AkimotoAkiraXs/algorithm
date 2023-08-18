//给你一个长度为 n 的整数数组
// nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 
//
// 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 
//
// 提示： 
// 
//
// 
// n == nums.length 
// 1 <= n <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 👍 685 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;665
 * <p>
 * Name：非递减数列
 *
 * @author Yuri
 * @since 2022-08-19 10:31:04
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        Solution solution = new NonDecreasingArray().new Solution();
        solution.checkPossibility(new int[]{3, 4, 2, 3});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 逻辑处理 第一次遇到递减时，判断是否满足改变一个数将该段数字变为非递减
        // 推导可得能改变的位置分别为i、i+1，
        // 所以条件为：(i - 1 < 0 || nums[i - 1] <= nums[i + 1]) || (i + 2 >= nums.length || nums[i + 2] > nums[i])
        public boolean checkPossibility(int[] nums) {
            boolean flag = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (flag && ((i - 1 < 0 || nums[i - 1] <= nums[i + 1]) || (i + 2 >= nums.length || nums[i + 2] > nums[i]))) {
                        flag = false;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}