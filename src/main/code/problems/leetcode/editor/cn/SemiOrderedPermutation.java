package problems.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;6424 <br/>
 * Name：Semi-Ordered Permutation <br/>
 *
 * @author Yuri
 * @since 2023-06-04 18:25
 */


public class SemiOrderedPermutation {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int semiOrderedPermutation(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            int a = list.indexOf(1);
            int b = list.indexOf(nums.length);
            return a > b ? a + nums.length - b - 1 - 1 : a + nums.length - b - 1;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
