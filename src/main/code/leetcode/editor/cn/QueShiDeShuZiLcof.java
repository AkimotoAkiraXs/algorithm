// English description is not available for the problem. Please switch to
// Chinese.
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 381 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;剑指 Offer 53 - II
 * <p>
 * Name：缺失的数字  LCOF
 *
 * @author Yuri
 * @since 2023-06-05 19:12:05
 */


public class QueShiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new QueShiDeShuZiLcof().new Solution();
        int i = solution.missingNumber(new int[]{0, 1, 2});
        System.out.println(i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = (r + l) / 2;
                if (nums[mid] == mid) l = mid + 1;
                else r = mid;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
