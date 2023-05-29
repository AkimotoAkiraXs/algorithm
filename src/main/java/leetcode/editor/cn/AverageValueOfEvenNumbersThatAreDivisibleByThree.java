package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2455 <br/>
 * Name：Average Value of Even Numbers That Are Divisible by Three <br/>
 *
 * @author Yuri
 * @since 2023-05-29 20:58:49
 */

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new AverageValueOfEvenNumbersThatAreDivisibleByThree().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int averageValue(int[] nums) {
            int cnt = 0, sum = 0;
            for (int num : nums) {
                if (num % 6 == 0) {
                    cnt++;
                    sum += num;
                }
            }
            return cnt == 0 ? 0 : sum / cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
