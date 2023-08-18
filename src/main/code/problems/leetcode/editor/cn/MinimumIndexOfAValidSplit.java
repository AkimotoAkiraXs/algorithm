package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;2780 <br/>
 * Name：Minimum Index of a Valid Split <br/>
 *
 * @author Yuri
 * @since 2023-07-18 21:56:03
 */

public class MinimumIndexOfAValidSplit {
    public static void main(String[] args) {
        Solution solution = new MinimumIndexOfAValidSplit().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 可以推出个结论 原数组支配元素和拆后支配元素是同一个
        public int minimumIndex(List<Integer> nums) {
            Map<Integer, Long> map = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Integer, Long> fMap = new HashMap<>();
            int m = nums.size();
            for (int i = 0; i < m - 1; i++) {
                Integer integer = nums.get(i);
                fMap.merge(integer, 1L, Long::sum);
                Long t = fMap.get(integer);
                Long all = map.get(integer);
                if (t * 2 > i + 1 && (all - t) * 2 > m - i - 1) return i;
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
