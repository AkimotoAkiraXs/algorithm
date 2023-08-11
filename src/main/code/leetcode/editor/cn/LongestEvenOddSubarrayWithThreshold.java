package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2760 <br/>
 * Name：Longest Even Odd Subarray With Threshold <br/>
 *
 * @author Yuri
 * @since 2023-07-03 22:44:43
 */

public class LongestEvenOddSubarrayWithThreshold {
    public static void main(String[] args) {
        Solution solution = new LongestEvenOddSubarrayWithThreshold().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 题意是找一个偶数开始，顺序是偶奇偶...顺序，所有数都小于threshold的子数组。
         * <p>
         * 暴力O(n^3) <br>
         * <p>
         * 其实可以分析子数组之间是不相交的（某个位置不符合要求则对所有符合要求的子数组都不符合要求），
         * 所以我们只需O(n)遍历即可，当中断时直接从中断位置开始搜下一个满足条件的即可。
         */
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int k = 0;
            int max = 0;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > threshold || (nums[i] & 1) != k) {
                    cnt = 0;
                    if ((k & 1) == 1) { // 连续两个偶数时，应该从中断（第二个）偶数开始遍历
                        k = 0;
                        i--;
                    }
                } else {
                    cnt++;
                    max = Math.max(max, cnt);
                    k = (k + 1) % 2;
                }
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
