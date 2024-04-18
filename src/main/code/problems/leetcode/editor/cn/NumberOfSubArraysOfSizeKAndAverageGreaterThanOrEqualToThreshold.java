//Given an array of integers arr and two integers k and threshold, return the 
//number of sub-arrays of size k and average greater than or equal to threshold. 
//
// 
// Example 1: 
//
// 
//Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
//Output: 3
//Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 
//respectively. All other sub-arrays of size 3 have averages less than 4 (the 
//threshold).
// 
//
// Example 2: 
//
// 
//Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
//Output: 6
//Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. 
//Note that averages are not integers.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= arr[i] <= 10⁴ 
// 1 <= k <= arr.length 
// 0 <= threshold <= 10⁴ 
// 
//
// 👍 56 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1343
 * <p>
 * Name：Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *
 * @author Yuri
 * @since 2024-04-18 16:42:06
 */

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public static void main(String[] args) {
        Solution solution = new NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold().new Solution();
        solution.numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int l = 0;
            int sum = 0;
            int cnt = 0;
            for (int r = 0; r < arr.length; r++) {
                sum += arr[r];
                if (r - l >= k) sum -= arr[l++];
                if (r - l == k - 1 && sum / k >= threshold) cnt++;
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}