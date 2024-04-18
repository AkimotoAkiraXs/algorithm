// There are several cards arranged in a row, and each card has an associated
// number of points. The points are given in the integer array cardPoints.
//
// In one step, you can take one card from the beginning or from the end of the 
// row. You have to take exactly k cards.
//
// Your score is the sum of the points of the cards you have taken. 
//
// Given the integer array cardPoints and the integer k, return the maximum 
// score you can obtain.
//
// 
// Example 1: 
//
// 
// Input: cardPoints = [1,2,3,4,5,6,1], k = 3
// Output: 12
// Explanation: After the first step, your score will always be 1. However,
// choosing the rightmost card first will maximize your total score. The optimal
// strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 1
// 2.
// 
//
// Example 2: 
//
// 
// Input: cardPoints = [2,2,2], k = 2
// Output: 4
// Explanation: Regardless of which two cards you take, your score will always
// be 4.
// 
//
// Example 3: 
//
// 
// Input: cardPoints = [9,7,7,9,7,7,9], k = 7
// Output: 55
// Explanation: You have to take all the cards. Your score is the sum of points
// of all cards.
// 
//
// 
// Constraints: 
//
// 
// 1 <= cardPoints.length <= 10⁵ 
// 1 <= cardPoints[i] <= 10⁴ 
// 1 <= k <= cardPoints.length 
// 
//
// 👍 391 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1423
 * <p>
 * Name：Maximum Points You Can Obtain from Cards
 *
 * @author Yuri
 * @since 2024-04-18 18:38:52
 */

public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
        solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        // 正向思维，枚举
        public int maxScore_(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int sum = 0;
            for (int i = 0; i < k; i++) sum += cardPoints[i];
            int max = sum;
            for (int i = 1; i <= k; i++) {
                sum -= cardPoints[k - i] - cardPoints[n - i];
                max = Math.max(max, sum);
            }
            return max;
        }

        // 逆向思维，滑动窗口
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int dis = n - k;
            int l = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int tot = 0;
            for (int r = 0; r < n; r++) {
                tot += cardPoints[r];
                sum += cardPoints[r];
                if (r - l >= dis) sum -= cardPoints[l++];
                if (r - l == dis - 1) min = Math.min(min, sum);
            }
            return tot - min;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}