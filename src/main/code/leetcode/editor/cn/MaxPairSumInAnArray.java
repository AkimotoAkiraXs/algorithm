package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2815 <br/>
 * Name：Max Pair Sum in an Array <br/>
 *
 * @author Yuri
 * @since 2023-08-14 21:54:58
 */

public class MaxPairSumInAnArray {
    public static void main(String[] args) {
        Solution solution = new MaxPairSumInAnArray().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // O(n)
        public int maxSum(int[] nums) {
            int ans = -1;
            int[] map = new int[10];
            Arrays.fill(map, Integer.MIN_VALUE);
            for (int num : nums) {
                int k = getMaxBit(num);
                ans = Math.max(ans, map[k] + num);
                map[k] = Math.max(map[k], num);
            }
            return ans;
        }

        // Bf O(n)
        public int maxSum_bf(int[] nums) {
            int ans = -1;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++)
                    if (getMaxBit(nums[i]) == getMaxBit(nums[j])) ans = Math.max(ans, nums[i] + nums[j]);
            }
            return ans;
        }

        private int getMaxBit(int x) {
            return String.valueOf(x).chars().max().getAsInt() - '0';
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
