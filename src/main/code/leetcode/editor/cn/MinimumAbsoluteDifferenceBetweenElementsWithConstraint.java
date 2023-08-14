package leetcode.editor.cn;

import java.util.List;
import java.util.TreeSet;

/**
 * Id：&emsp;&emsp;2817 <br/>
 * Name：Minimum Absolute Difference Between Elements With Constraint <br/>
 *
 * @author Yuri
 * @since 2023-08-14 21:55:11
 */

public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceBetweenElementsWithConstraint().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    @SuppressWarnings("")
    class Solution {
        public int minAbsoluteDifference(List<Integer> nums, int x) {
            TreeSet<Integer> queue = new TreeSet<>();
            // 头尾放两个哨兵，保证后续的ceil和floor都有值
            queue.add(Integer.MAX_VALUE);
            queue.add(Integer.MIN_VALUE / 2); // 避免减法超内存
            int ans = Integer.MAX_VALUE;
            for (int i = x; i < nums.size(); i++) {
                queue.add(nums.get(i - x));
                Integer k = nums.get(i);
                // 做题的时候根本没想到有ceil和floor方法可以用
                ans = Math.min(ans, Math.min(queue.ceiling(k) - k, k - queue.floor(k)));
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
