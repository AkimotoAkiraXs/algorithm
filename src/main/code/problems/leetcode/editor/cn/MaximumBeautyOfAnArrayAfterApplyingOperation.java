package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2779 <br/>
 * Name：Maximum Beauty of an Array After Applying Operation <br/>
 *
 * @author Yuri
 * @since 2023-07-18 21:55:57
 */

public class MaximumBeautyOfAnArrayAfterApplyingOperation {
    public static void main(String[] args) {
        Solution solution = new MaximumBeautyOfAnArrayAfterApplyingOperation().new Solution();
        // solution.maximumBeauty(new int[]{4, 6, 1, 2}, 2);

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 滑动窗口（双指针）：维护左右两个指针，保持范围<=2*k，更新两个指针距离
        public int maximumBeauty(int[] nums, int k) {
            Arrays.sort(nums);
            int r = 0, ans = 0;
            for (int l = 0; l < nums.length; l++) {
                while (nums[l] - nums[r] > 2 * k) r++;
                ans = Math.max(ans, l - r + 1);
            }
            return ans;
        }

        // 二分搜索O(nlogn)：排序后，枚举每个值x为最小值，x+2*k就是题目要求的最大值，通过二分搜索x+2*k，不断更新长度获取最长长度
        class binary {
            public int maximumBeauty(int[] nums, int k) {
                Arrays.sort(nums);
                int ans = 0;
                for (int i = 0; i < nums.length; i++) {
                    int j = biSearchLeft(nums, nums[i] + 2 * k);
                    ans = Math.max(ans, j - i);
                }
                return ans;
            }

            int biSearchLeft(int[] nums, int key) {
                int l = 0, r = nums.length;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (nums[mid] <= key) l = mid + 1;
                    else r = mid;
                }
                return l;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
