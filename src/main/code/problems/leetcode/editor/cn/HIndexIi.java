// Given an array of integers citations where citations[i] is the number of
// citations a researcher received for their iᵗʰ paper and citations is sorted in
// ascending order, return the researcher's h-index.
//
// According to the definition of h-index on Wikipedia: The h-index is defined 
// as the maximum value of h such that the given researcher has published at least
// h papers that have each been cited at least h times.
//
// You must write an algorithm that runs in logarithmic time. 
//
// 
// Example 1: 
//
// 
// Input: citations = [0,1,3,5,6]
// Output: 3
// Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each
// of them had received 0, 1, 3, 5, 6 citations respectively.
// Since the researcher has 3 papers with at least 3 citations each and the
// remaining two with no more than 3 citations each, their h-index is 3.
// 
//
// Example 2: 
//
// 
// Input: citations = [1,2,100]
// Output: 2
// 
//
// 
// Constraints: 
//
// 
// n == citations.length 
// 1 <= n <= 10⁵ 
// 0 <= citations[i] <= 1000 
// citations is sorted in ascending order. 
// 
//
// 👍 284 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;275
 * <p>
 * Name：H-Index II
 *
 * @author Yuri
 * @since 2023-10-30 19:24:25
 */

public class HIndexIi {

    public static void main(String[] args) {
        Solution solution = new HIndexIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int hIndex(int[] citations) {
            int n = citations.length;
            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (citations[mid] < (n - mid)) l = mid + 1;
                else r = mid;
            }
            return n - r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}