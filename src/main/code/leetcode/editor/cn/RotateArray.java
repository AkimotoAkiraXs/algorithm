//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 数学 双指针 
// 👍 1135 👎 0


/*
 * Id：189
 * Name：旋转数组
 * Date：2021-09-26 09:48:17
 */
package leetcode.editor.cn;

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        solution.rotate(nums, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
/*
            //数组复制
            int length = nums.length;
            int[] temp = new int[length];
            for (int i = 0; i < nums.length; i++) {
                temp[(i + k) % length] = nums[i];
            }
            System.arraycopy(temp, 0, nums, 0, length);*/
/*
            //数学-环状替换
            int l = nums.length;
            k %= l;
            int loop = gcd(k, l);
            for (int i = 0; i < loop; i++) {
                int index = i;
                int temp, last = nums[i];
                do {
                    index = (index + k) % l;
                    temp = nums[index];
                    nums[index] = last;
                    last = temp;
                } while (index != i);
            }*/

            //翻转数组
            int l = nums.length;
            k %= l;
            reverse(nums, 0, l - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, l - 1);
        }

        //法2 辗转相除法求最大公约数
        private int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }

        //法3 reverse翻转数组
        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
} 