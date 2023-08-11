package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;633
 * <p>
 * Name：平方数之和
 *
 * @author Yuri
 * @since 2023-02-12 05:16:25
 */

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
/*
            // sqrt
            int sqrt = (int) Math.sqrt(c);
            for (int i = 0; i <= sqrt; i++) {
                int b = c - i * i;
                double sqrtB = Math.sqrt(b);
                double eps = 1e-10; // 精度范围
                if (sqrtB - Math.floor(sqrtB) < eps) return true;
            }
            return false;
*/


            /*
            * 双指针
            * 证明：在移动的过程中i < a <= b = j，此时，j指针犯下错误，j--使得j指针错过了右端点b，但是这是不可能的因为移动前i*i+j*j是小于a*a+b*b的因为i < a，根据双指针算法此时只会i++,故该情况不存在
            * i = a <= b < j 情况同理
            * */
/*
            long b = (int) Math.sqrt(c);
            long a = 0;
            while (a <= b) {
                long sum = a * a + b * b;
                if (sum == c) return true;
                else if (sum > c) b--;
                else a++;
            }
            return false;
*/

            /*
            * 费马平方和定理：一个非负整数 c 如果能够表示为两个整数的平方和，当且仅当 c 的所有形如 4k+3 的质因子所对应的指数均为偶数
            * 意思：c进行质因数分解时，分解出来的 4k+3 形式的质因子都得是偶数个。
            * 例如 9=3*3可以，18=3*3*2可以，27=3*3*3不可以，以为这里质因子3有3个，171=19*3*3不可以因为19也是4k+3形式的但是只有一个
            * */
            for (int i = 2, cnt = 0; i * i <= c; i++, cnt = 0) { //因为质因子必须是偶数个，所以这里范围到sqrt(c)即可
                while (c % i == 0 && ++cnt > 0) c /= i;
                if (i % 4 == 3 && cnt % 2 != 0) return false;
            }
            // 如果c本身就是个质数
            // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c，base == 11 的时候不会进入循环体
            return c % 4 != 3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
