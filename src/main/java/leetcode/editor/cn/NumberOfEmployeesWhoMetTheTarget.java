package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2798 <br/>
 * Name：Number of Employees Who Met the Target <br/>
 *
 * @author Yuri
 * @since 2023-08-13 10:00:31
 */

public class NumberOfEmployeesWhoMetTheTarget {
    public static void main(String[] args) {
        Solution solution = new NumberOfEmployeesWhoMetTheTarget().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            return (int) Arrays.stream(hours).filter(o -> o >= target).count();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
