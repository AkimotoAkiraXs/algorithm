//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 数学 排序 👍 390 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;628
 * <p>
 * Name：三个数的最大乘积
 *
 * @author Yuri
 * @since 2022-08-11 10:56:23
 */
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
        solution.maximumProduct(new int[]{1, 2, 3, 4});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

/*
        // 排序暴力
        public int maximumProduct(int[] nums) {
            int length = nums.length;
            Arrays.sort(nums);
            int a = nums[length - 1] * nums[length - 2] * nums[length - 3];
            int b = nums[0] * nums[1] * nums[length - 1];
            return Math.max(a, b);
        }
*/

        // 线性扫描 提取最大的三个数和最小的两个数 关键在于继承
        public int maximumProduct(int[] nums) {
            int a, b, c, d, e;
            a = b = Integer.MAX_VALUE;
            c = d = e = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num < a) {
                    b = a;
                    a = num;
                }
                else if (num < b) b = num;
                if (num > e) {
                    c = d;
                    d = e;
                    e = num;
                } else if (num > d) {
                    c = d;
                    d = num;
                }
                else if (num > c) c = num;
            }
            int x = e * d * c;
            int y = a * b * e;
            return Math.max(x, y);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}