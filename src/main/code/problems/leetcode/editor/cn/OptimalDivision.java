//给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。 
//
// 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应
//该含有冗余的括号。 
//
// 示例： 
//
// 
//输入: [1000,100,10,2]
//输出: "1000/(100/10/2)"
//解释:
//1000/(100/10/2) = 1000/((100/10)/2) = 200
//但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
//因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
//
//其他用例:
//1000/(100/10)/2 = 50
//1000/(100/(10/2)) = 50
//1000/100/10/2 = 0.5
//1000/100/(10/2) = 2
// 
//
// 说明: 
//
// 
// 输入数组的长度在 [1, 10] 之间。 
// 数组中每个元素的大小都在 [2, 1000] 之间。 
// 每个测试用例只有一个最优除法解。 
// 
//
// Related Topics 数组 数学 动态规划 👍 193 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;553
 * <p>
 * Name：最优除法
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class OptimalDivision {
    public static void main(String[] args) {
        Solution solution = new OptimalDivision().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心、脑筋急转弯 <br/>
         * 求最大值：∵所有数都是正整数，第二个数肯定要除，保证其他数全乘则能得到最大值 <br/>
         */

        public String optimalDivision(int[] nums) {
            StringBuilder ans = new StringBuilder();
            int n = nums.length;
            ans.append(nums[0]);
            for (int i = 1; i < n; i++) {
                if (i == 1) {
                    ans.append("/");
                    if (n > 2) ans.append("(");
                }
                ans.append(nums[i]);
                if (i < n - 1) ans.append("/");
                else if (n > 2) ans.append(")");
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}