//对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。 
//
// 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。 
//
// 
//
// 示例 1： 
//
// 
//输入："13"
//输出："3"
//解释：13 的 3 进制是 111。
// 
//
// 示例 2： 
//
// 
//输入："4681"
//输出："8"
//解释：4681 的 8 进制是 11111。
// 
//
// 示例 3： 
//
// 
//输入："1000000000000000000"
//输出："999999999999999999"
//解释：1000000000000000000 的 999999999999999999 进制是 11。
// 
//
// 
//
// 提示： 
//
// 
// n的取值范围是 [3, 10^18]。 
// 输入总是有效且没有前导 0。 
// 
//
// 
// Related Topics 数学 二分查找 
// 👍 125 👎 0


/*
 * Id：483
 * Name：最小好进制
 * Date：2021-06-22 15:06:19
 */
package problems.leetcode.editor.cn;

public class SmallestGoodBase {
    public static void main(String[] args) {
        Solution solution = new SmallestGoodBase().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分法
        public long pow(long mid, int j) {
            long res = mid;
            for (int i = 1; i < j; i++) {
                if (Long.MAX_VALUE / mid < res) { //防止超出long上限
                    return -1;
                }
                res *= mid;
            }
            return res;
        }

        public long calculate(long mid, int i) {
            long sum = 1;
            for (int j = i - 1; j > 0; j--) {
                long p;
                if ((p = pow(mid, j)) == -1) {
                    return -1;
                }
                sum += p;
            }
            return sum;
        }

        public String smallestGoodBase(String n) {
            long num = Long.parseLong(n), mid;
            for (int i = 63; i >= 2; i--) {
                long l = num, r = 2;
                while (r < l) {
                    mid = l + r >>> 1;
                    long sum = calculate(mid, i);
                    if (sum == num) {
                        return String.valueOf(mid);
                    } else if (sum > num || sum == -1) {
                        l = mid;
                    } else {
                        r = mid + 1;
                    }
                }
            }
            return String.valueOf(0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 