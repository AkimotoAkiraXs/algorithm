//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 👍 1721 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;33
 * <p>
 * Name：搜索旋转排序数组
 *
 * @author Yuri
 * @since 2021-12-15 17:07:30
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] ints = {1,5,3};
        solution.search(ints, 5);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums[0] == target) return 0;
            int a = 0, b = nums.length;
            while (a < b - 1) {
                int mid = (a + b) >> 1;
                if (nums[mid] > nums[0]) {
                    a = mid;
                } else {
                    b = mid;
                }
            }
            if (b == nums.length) {
                a = 0;
            } else if (nums[0] > target) {
                a = b;
                b = nums.length;
            } else {
                b = a + 1;
                a = 0;
            }
            int mid ;
            while (a < b) {
                mid = (a + b) >> 1;
                if (nums[mid] > target) {
                    b = mid;
                } else if (nums[mid] < target) {
                    a = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}