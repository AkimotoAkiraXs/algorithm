//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics 贪心 数组 双指针 👍 3520 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;11
 * <p>
 * Name：盛最多水的容器
 *
 * @author Yuri
 * @since 2022-05-26 15:31:08
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * <p>
         * 双指针 博弈论
         * </p>
         * Reflection: 从两边向内进行收缩（宽度逐渐减小）
         * 每次相交矮的一边边收缩一格（试想矮边固定，此时容器高度最高就是此高度，
         * 而向内收缩过程宽度减小，所以含有该边容器的最大面积已经取到）
         * 如此一来，整个收缩过程中最大值则是答案
         */
        public int maxArea(int[] height) {
            int x = 0, y = height.length - 1;
            int max = Integer.MIN_VALUE;
            while (x < y) {
                max = Math.max(max, (y - x) * Math.min(height[x], height[y]));
                if (height[x] <= height[y]) x++;
                else y--;
            }
            return max;
        }
/*
        // 暴力 双重for
        public int maxArea(int[] height) {
            int ans = Integer.MIN_VALUE;
            int maxi = Integer.MIN_VALUE;
            for (int i = 0; i < height.length; i++) {
                if (maxi >= height[i]) continue;
                else maxi = height[i];
                for (int j = i + 1; j < height.length; j++) {
                    ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
                }
            }
            return ans;
        }
*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}