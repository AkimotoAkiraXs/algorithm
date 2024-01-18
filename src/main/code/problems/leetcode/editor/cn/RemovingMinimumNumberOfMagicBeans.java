// You are given an array of positive integers beans, where each integer
// represents the number of magic beans found in a particular magic bag.
//
// Remove any number of beans (possibly none) from each bag such that the 
// number of beans in each remaining non-empty bag (still containing at least one bean)
// is equal. Once a bean has been removed from a bag, you are not allowed to return
// it to any of the bags.
//
// Return the minimum number of magic beans that you have to remove. 
//
// 
// Example 1: 
//
// 
// Input: beans = [4,1,6,5]
// Output: 4
// Explanation:
//- We remove 1 bean from the bag with only 1 bean.
//  This results in the remaining bags: [4,0,6,5]
//- Then we remove 2 beans from the bag with 6 beans.
//  This results in the remaining bags: [4,0,4,5]
//- Then we remove 1 bean from the bag with 5 beans.
//  This results in the remaining bags: [4,0,4,4]
// We removed a total of 1 + 2 + 1 = 4 beans to make the remaining non-empty
// bags have an equal number of beans.
// There are no other solutions that remove 4 beans or fewer.
// 
//
// Example 2: 
//
// 
// Input: beans = [2,10,3,2]
// Output: 7
// Explanation:
//- We remove 2 beans from one of the bags with 2 beans.
//  This results in the remaining bags: [0,10,3,2]
//- Then we remove 2 beans from the other bag with 2 beans.
//  This results in the remaining bags: [0,10,3,0]
//- Then we remove 3 beans from the bag with 3 beans. 
//  This results in the remaining bags: [0,10,0,0]
// We removed a total of 2 + 2 + 3 = 7 beans to make the remaining non-empty
// bags have an equal number of beans.
// There are no other solutions that removes 7 beans or fewer.
// 
//
// 
// Constraints: 
//
// 
// 1 <= beans.length <= 10⁵ 
// 1 <= beans[i] <= 10⁵ 
// 
//
// 👍 82 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2171
 * <p>
 * Name：Removing Minimum Number of Magic Beans
 *
 * @author Yuri
 * @since 2024-01-18 11:02:44
 */

public class RemovingMinimumNumberOfMagicBeans {

    public static void main(String[] args) {
        Solution solution = new RemovingMinimumNumberOfMagicBeans().new Solution();
        solution.minimumRemoval(new int[]{43, 44, 45, 46, 47});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 灵神的，一次循环，求和求矩形一起算，最后加减得答案
        public long minimumRemoval(int[] beans) {
            Arrays.sort(beans);
            long sum = 0;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < beans.length; i++) {
                sum += beans[i];
                max = Math.max(max, (long) (beans.length - i) * beans[i]);
            }
            return sum - max;
        }

        // 自己做的，两次循环，第一求和，第二次利用几何求ans
        public long minimumRemoval_self(int[] beans) {
            Arrays.sort(beans);
            int len = beans.length;
            long[] sum = new long[len];
            sum[0] = beans[0];
            for (int i = 1; i < len; i++) sum[i] += sum[i - 1] + beans[i]; // 前缀和

            // 几何公式求和
            long ans = sum[len - 1] - (long) len * beans[0]; // 初始值
            for (int i = 1; i < len; i++) {
                if (beans[i] == beans[i - 1]) continue;
                ans = Math.min(ans, sum[i - 1] + (sum[len - 1] - sum[i - 1] - (long) (len - i) * beans[i]));
            }
            return ans;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}