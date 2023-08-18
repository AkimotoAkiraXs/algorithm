package problems.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Id：&emsp;&emsp;2208 <br/>
 * Name：Minimum Operations to Halve Array Sum <br/>
 *
 * @author Yuri
 * @since 2023-07-25 23:18:54
 */

public class MinimumOperationsToHalveArraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToHalveArraySum().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int halveArray(int[] nums) {
            PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder()); // 这里是double 不能用o1-o2
            long sum = 0; // 注意int会爆内存
            for (int num : nums) {
                sum += num;
                queue.add((double) num);
            }
            double aim = sum / 2.0;
            int res = 0;
            while (aim > 0) {
                Double d = queue.poll();
                aim -= d / 2;
                queue.add(d / 2);
                res++;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
