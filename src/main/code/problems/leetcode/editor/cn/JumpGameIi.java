// 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
// 输入: nums = [2,3,0,1,4]
// 输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1677 👎 0


package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;45
 * <p>
 * Name：跳跃游戏 II
 *
 * @author Yuri
 * @since 2022-07-06 17:52:30
 */
public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        int[] min = new int[10];
        Arrays.fill(min, Integer.MIN_VALUE);
        System.out.println(min[8]);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
/*
        // 正向求出到达每一个位置所需最小步数
        public int jump(int[] nums) {
            int[] minimals = new int[nums.length];
            Arrays.fill(minimals, Integer.MAX_VALUE);
            minimals[0] = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] + j >= i) {
                        minimals[i] = Math.min(minimals[j] + 1, minimals[i]);
                    }
                }
            }
            return minimals[nums.length-1];
        }
        */

        // 求出每一步所能到达的最大位置
        public int jump(int[] nums) {
            int end = 0;
            int max = 0;
            int step = 0;
            // 最后一格已完成任务，无需再跳
            for (int i = 0; i < nums.length - 1; i++) {
                max = Math.max(max, i + nums[i]);
                if (i == end) {
                    end = max;
                    step++;
                }
            }
            return step;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}