//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
//
// Related Topics 数学 字符串 模拟 👍 105 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;592
 * <p>
 * Name：分数加减运算
 *
 * @author Yuri
 * @since 2022-07-27 17:50:31
 */
public class FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        Solution solution = new FractionAdditionAndSubtraction().new Solution();

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int i = 0;
        String s;
        int sign;
        int a, b;
        int numerator = 0, denominator = 1;

        public String fractionAddition(String expression) {
            if (expression.charAt(0) != '-') s = '+' + expression;
            else s = expression;
            boolean numeratorFlag = true;
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '+' || c == '-') {
                    if (c == '+') sign = 1;
                    else sign = -1;
                    numeratorFlag = true;
                } else if (c == '/') {
                    numeratorFlag = false;
                } else if (numeratorFlag) {
                    a = sign * getNum();
                } else {
                    b = getNum();
                    calculate(a, b);
                }
            }

            int[] prime = new int[]{2, 3, 5, 7, 11};
            for (int pri : prime) {
                while ((numerator % pri) == 0 && (denominator % pri) == 0) {
                    numerator /= pri;
                    denominator /= pri;
                }
            }
            return String.valueOf(numerator) + '/' + denominator;
        }

        private void calculate(int a, int b) {
            int lcm = lcm(denominator, b);
            numerator = (lcm / b * a + lcm / denominator * numerator);
            denominator = lcm;
        }

        private int getNum() {
            int k = s.charAt(this.i) - '0';
            if (this.i + 1 < s.length() && s.charAt(i + 1) == '0') {
                k = 10;
                i++;
            }
            return k;
        }

        private int lcm(int a, int b) {
            if (b > a) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (a * b == 0) return 0;
            return (a * b) / gcd(a, b);
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}