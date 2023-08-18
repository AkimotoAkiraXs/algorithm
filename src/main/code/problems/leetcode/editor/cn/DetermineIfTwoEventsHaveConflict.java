package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2446 <br/>
 * Name：Determine if Two Events Have Conflict <br/>
 *
 * @author Yuri
 * @since 2023-05-17 22:51:21
 */

public class DetermineIfTwoEventsHaveConflict {
    public static void main(String[] args) {
        Solution solution = new DetermineIfTwoEventsHaveConflict().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            return event1[1].compareTo(event2[0]) >= 0 && event1[0].compareTo(event2[1]) <= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
