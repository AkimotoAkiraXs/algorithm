package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Id：&emsp;&emsp;217
 * <p>
 * Name：存在重复元素
 *
 * @author Yuri
 * @since 2023-02-12 05:03:14
 */

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.add(num)) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
