//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1240 👎 0


/*
 * Id：55
 * Name：跳跃游戏
 * Date：2021-06-22 14:48:46
 */
package leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {

        Solution solution = new JumpGame().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] s;
        int length;

        public boolean jump(int index, boolean res) {
            if (res || s[index] == -1) {
                return res;
            }
            int k = s[index];
            s[index] = -1; //标记位置
            if (k + index + 1 >= length) {
                return true;
            }
            for (int i = 1; i <= k; i++) {
                if (jump(index + i, res)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canJump(int[] nums) {
            s = nums;
            length = nums.length;
            return jump(0, false);
        }

        //标准题解
        public boolean canJumpAC(int[] nums) {
            int r = 0;  //能跳到最右边的点
            for (int i = 0; i < nums.length; ++i) {
                if (i <= r) {   //如果i小于等于r代表能到达i这个点
                    r = Math.max(r, i + nums[i]);   //更新能达到的最右边的点
                    if (r >= nums.length - 1) {
                        return true;//如果最右边的点超过了数组大小，返回true
                    }
                }
            }
            return false;   //说明达不到最右边，返回false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}