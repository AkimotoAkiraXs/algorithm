//
//
// Winston was given the above mysterious function func. He has an integer 
// array arr and an integer target and he wants to find the values l and r that make
// the value |func(arr, l, r) - target| minimum possible.
//
// Return the minimum possible value of |func(arr, l, r) - target|. 
//
// Notice that func should be called with the values l and r where 0 <= l, r < 
// arr.length.
//
// 
// Example 1: 
//
// 
// Input: arr = [9,12,3,7,15], target = 5
// Output: 2
// Explanation: Calling func with all the pairs of [l,r] = [[0,0],[1,1],[2,2],[3,
// 3],[4,4],[0,1],[1,2],[2,3],[3,4],[0,2],[1,3],[2,4],[0,3],[1,4],[0,4]], Winston
// got the following results [9,12,3,7,15,8,0,3,7,0,0,3,0,0,0]. The value closest
// to 5 is 7 and 3, thus the minimum difference is 2.
// 
//
// Example 2: 
//
// 
// Input: arr = [1000000,1000000,1000000], target = 1
// Output: 999999
// Explanation: Winston called the func with all possible values of [l,r] and he
// always got 1000000, thus the min difference is 999999.
// 
//
// Example 3: 
//
// 
// Input: arr = [1,2,4,8,16], target = 0
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= arr[i] <= 10⁶ 
// 0 <= target <= 10⁷ 
// 
//
// 👍 69 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;1521
 * <p>
 * Name：Find a Value of a Mysterious Function Closest to Target
 *
 * @author Yuri
 * @since 2024-07-04 17:49:09
 */

public class FindAValueOfAMysteriousFunctionClosestToTarget {

    public static void main(String[] args) {
        Solution solution = new FindAValueOfAMysteriousFunctionClosestToTarget().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int closestToTarget(int[] arr, int target) {
            var ads = new ArrayList<int[]>();
            int ans = Integer.MAX_VALUE;
            for (int num : arr) {
                int k = 0;
                ads.add(new int[]{Integer.MAX_VALUE});
                for (int[] ad : ads) {
                    ad[0] &= num;
                    ans = Math.min(ans, Math.abs(ad[0] - target));
                    if (ad[0] != ads.get(k)[0]) ads.set(++k, ad);
                }
                ads.subList(k + 1, ads.size()).clear();
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}