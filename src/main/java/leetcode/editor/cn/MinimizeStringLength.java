package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;6462 <br/>
 * Name：MinimizeStringLength <br/>
 *
 * @author Yuri
 * @since 2023-06-04 18:11
 */

public class MinimizeStringLength {
    public static void main(String[] args) {
        Solution solution = new MinimizeStringLength().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimizedStringLength(String s) {
            Set<Character> hash = new HashSet<>();
            for (Character c : s.toCharArray()) hash.add(c);
            return hash.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

