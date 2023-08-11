//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1239 👎 0


/*
 * Id：283
 * Name：移动零
 * Date：2021-09-27 14:17:48
 */
package leetcode.editor.cn;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int l = nums.length;
            int k = 0;
            for (int i = 0; i < l; i++) {
                if (nums[i] == 0) k++;
                else nums[i - k] = nums[i];
            }
            for (int i = 0; i < k; i++) {
                nums[l - i - 1] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 