//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// Related Topics 数组 滑动窗口 👍 555 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;713
 * <p>
 * Name：乘积小于 K 的子数组
 *
 * @author Yuri
 * @since 2022-05-27 10:38:21
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        int[] a = new int[]{3, 3, 3};
        int ans = solution.numSubarrayProductLessThanK(a, 2);
        System.out.println("ans:" + ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k == 0 || k == 1) return 0;
            int ans = 0, b = 0, n = 1;
            for (int i = 0; i < nums.length; i++) {
                n *= nums[i];
                while (n >= k) n /= nums[b++];
                ans += i - b + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
