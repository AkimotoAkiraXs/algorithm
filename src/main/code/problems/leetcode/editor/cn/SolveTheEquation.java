//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解或存在的解不为整数，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// 方程由绝对值在 [0, 100] 范围内且无任何前导零的整数和变量 'x' 组成。 
// 
//
// Related Topics 数学 字符串 模拟 👍 193 👎 0

package problems.leetcode.editor.cn;

import java.util.Objects;

/**
 * Id：&emsp;&emsp;640
 * <p>
 * Name：求解方程
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class SolveTheEquation {
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation().new Solution();
        solution.solveEquation("-x=-1");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int a = 0, x = 0;

        public String solveEquation(String equation) {
            equation = equation.replace("-", "+-");
            equation = equation.replaceAll("(\\D)x|^x", "$11x"); // 可以利用正则替换x,-x为1x,-1x，但是会慢很多。 7ms 7.07%
            int e = equation.indexOf("=");
            String[] left = equation.substring(0, e).split("\\+");
            String[] right = equation.substring(e + 1).split("\\+");
            calculate(left, 1);
            calculate(right, -1);
            return x == 0 ? a == 0 ? "Infinite solutions" : "No solution" : "x=" + -1 * a / x;
        }

        void calculate(String[] strings, int operative) {
            for (String str : strings) {
                if (Objects.equals(str, "")) continue;
/*                // 做if判断会比正则快很多 3ms 91.2%
                if (str.equals("x")) {
                    x += operative;
                    continue;
                }
                if (str.equals("-x")) {
                    x -= operative;
                    continue;
                }*/
                boolean xFlag = false;
                if (str.charAt(str.length() - 1) == 'x') {
                    xFlag = true;
                    str = str.substring(0, str.length() - 1);
                }
                int k = Integer.parseInt(str);
                if (xFlag) x += operative * k;
                else a += operative * k;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}