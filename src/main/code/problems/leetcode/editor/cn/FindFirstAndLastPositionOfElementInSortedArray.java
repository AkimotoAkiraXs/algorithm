// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
//
// 示例 2： 
//
// 
// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]
//
// 示例 3： 
//
// 
// 输入：nums = [], target = 0
// 输出：[-1,-1]
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1338 👎 0


package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;34
 * <p>
 * Name：在排序数组中查找元素的第一个和最后一个位置
 *
 * @author Yuri
 * @since 2021-12-15 14:37:52
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        // System.out.println(solution.binarySearch(new int[]{1, 2, 3, 5, 5, 6, 8, 9, 9, 9, 9}, 6));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] searchRange(int[] nums, int target) {
            int first = binarySearch(nums, target);
            if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
            int last = binarySearch(nums, target + 1) - 1;
            return new int[]{first, last};
        }

        private int binarySearch(int[] nums, int key) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < key) l = mid + 1; // 去掉等号则会找大于等于，加上等号则会只找大于
                else r = mid;
            }
            return l;
        }

        // 暴力，先二分找到具体数字，然后左右分别遍历搜索最末端，复杂度为O(n)不符合题意
        public int[] searchRange_brute(int[] nums, int target) {
            int a = 0, b = nums.length, index;
            int[] ans = new int[]{-1, -1};
            while (a < b) {
                index = (a + b) >> 1;
                if (nums[index] < target) {
                    a = index + 1;
                } else if (nums[index] > target) {
                    b = index;
                } else {
                    ans[0] = ans[1] = index;
                    int k = index;
                    while (k - 1 >= 0 && nums[k - 1] == target) {
                        ans[0] = --k;
                    }
                    k = index;
                    while (k + 1 < nums.length && nums[k + 1] == target) {
                        ans[1] = ++k;
                    }
                    break;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}