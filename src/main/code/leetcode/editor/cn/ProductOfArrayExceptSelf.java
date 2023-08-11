//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
//
// Related Topics 数组 前缀和 👍 1241 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;238
 * <p>
 * Name：除自身以外数组的乘积
 *
 * @author Yuri
 * @since 2022-08-25 15:35:02
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目要求不能用除法！！！
        // 正解：前缀和计算任意位置左右两边乘积
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            int[] lSum = new int[n + 2];
            int[] rSum = new int[n + 2];
            lSum[0] = rSum[n - 1] = 1;
            // sum of left
            for (int i = 1; i <= n; i++) lSum[i] = lSum[i - 1] * nums[i - 1];
            // sum of right
            for (int i = n - 2; i >= 0; i--) rSum[i] = rSum[i + 1] * nums[i + 1];

            for (int i = 0; i < n; i++) ans[i] = lSum[i] * rSum[i];

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}