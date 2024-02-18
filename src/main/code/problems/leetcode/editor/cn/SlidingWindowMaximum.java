// You are given an array of integers nums, there is a sliding window of size k
// which is moving from the very left of the array to the very right. You can only
// see the k numbers in the window. Each time the sliding window moves right by one
// position.
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation:
// Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
// Input: nums = [1], k = 1
// Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// 👍 2697 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;239
 * <p>
 * Name：Sliding Window Maximum
 *
 * @author Yuri
 * @since 2024-02-18 14:39:53
 */

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1, -1}, 1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] res = new int[n - k + 1];
            Deque<Integer> q = new LinkedList<>();
            // 先加入前k-1个元素进队列
            for (int i = 0; i < k - 1; i++) {
                while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.removeLast();
                q.add(i);
            }
            // 分别加入后面元素，计算当前窗口最大值
            for (int i = k - 1; i < n; i++) {
                if (!q.isEmpty() && q.element() <= i - k) q.remove();
                while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.removeLast();
                q.add(i);
                res[i - k + 1] = nums[q.element()];
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}