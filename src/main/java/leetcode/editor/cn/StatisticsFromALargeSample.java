package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1093 <br/>
 * Name：Statistics from a Large Sample <br/>
 *
 * @author Yuri
 * @since 2023-05-27 10:06:00
 */

public class StatisticsFromALargeSample {
    public static void main(String[] args) {
        Solution solution = new StatisticsFromALargeSample().new Solution();
        solution.sampleStats(new int[]{
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        });
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] sampleStats(int[] count) {
            double min = -1, max = 0, mean = 0, median = 0, mode = 0;
            long sum = 0;
            int total = Arrays.stream(count).sum();
            int mx = 0;
            int cnt = 0;
            int left = (total + 1) / 2, right = (total + 2) / 2;
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    if (min == -1) min = i;
                    max = i;
                    sum += (long) i * count[i];
                    if (count[i] > mx) {
                        mx = count[i];
                        mode = i;
                    }
                    if (cnt < left && cnt + count[i] >= left) median += i;
                    if (cnt < right && cnt + count[i] >= right) median+= i;
                    cnt += count[i];
                }
            }
            mean = (double) sum / total;
            median /= 2.0;

            return new double[]{min, max, mean, median, mode};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
