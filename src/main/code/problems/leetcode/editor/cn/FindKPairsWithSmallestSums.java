// You are given two integer arrays nums1 and nums2 sorted in non-decreasing
// order and an integer k.
//
// Define a pair (u, v) which consists of one element from the first array and 
// one element from the second array.
//
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums. 
//
//
// 
// Example 1: 
//
// 
// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]]
// Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,
// 6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// Example 2: 
//
// 
// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [[1,1],[1,1]]
// Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,
// 2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 and nums2 both are sorted in non-decreasing order. 
// 1 <= k <= 10⁴ 
// k <= nums1.length * nums2.length 
// 
//
// 👍 614 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Id：&emsp;&emsp;373
 * <p>
 * Name：Find K Pairs with Smallest Sums
 *
 * @author Yuri
 * @since 2024-09-20 16:02:19
 */

public class FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 优先队列：每次拿出最小的(i,j)时把(i+1,j)、(i,j+1)塞入队列，但避免重复塞所以只赛(i,j+1)，
         * 此时初始化需要把(0,0)、(1,0)、(2,0)...(n,0)塞入队列，为了避免开始就塞入（全部加入队列增加复杂度），
         * 所以每次遇到j=0时再把(i,0)塞入队列
         *
         * @see <a href="https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solutions/2286318/jiang-qing-chu-wei-shi-yao-yi-kai-shi-ya-i0dj/">Lc373.查找和最小的K对数字 灵神题解</a>
         */
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            List<List<Integer>> ans = new ArrayList<>();
            queue.add(new int[]{nums1[0] + nums2[0], 0, 0});
            while (ans.size() < k) {
                int[] q = queue.poll();
                int i = q[1], j = q[2];
                ans.add(List.of(nums1[i], nums2[j]));
                if (j == 0 && i + 1 < nums1.length) queue.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                if (j + 1 < nums2.length) queue.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}