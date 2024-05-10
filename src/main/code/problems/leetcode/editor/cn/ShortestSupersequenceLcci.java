// You are given two arrays, one shorter (with all distinct elements) and one
// longer. Find the shortest subarray in the longer array that contains all the
// elements in the shorter array. The items can appear in any order.
//
// Return the indexes of the leftmost and the rightmost elements of the array. 
// If there are more than one answer, return the one that has the smallest left
// index. If there is no answer, return an empty array.
//
// Example 1: 
//
// 
// Input:
// big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
// small = [1,5,9]
// Output: [7,10]
//
// Example 2: 
//
// 
// Input:
// big = [1,2,3]
// small = [4]
// Output: []
//
// Note: 
//
// 
// big.length <= 100000 
// 1 <= small.length <= 100000 
// 
//
// 👍 72 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;面试题 17.18
 * <p>
 * Name：Shortest Supersequence LCCI
 *
 * @author Yuri
 * @since 2024-05-09 18:48:03
 */

public class ShortestSupersequenceLcci {

    public static void main(String[] args) {
        Solution solution = new ShortestSupersequenceLcci().new Solution();
        int[] ints = solution.shortestSeq(
            new int[]{521704, 897261, 279103, 381783, 668374, 934085, 254258, 726184, 496153, 804155},
            new int[]{897261, 934085, 381783, 496153});
        System.out.println(Arrays.toString(ints));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] shortestSeq(int[] big, int[] small) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int k : small) cnt.merge(k, 1, Integer::sum);
            Set<Integer> hash = Arrays.stream(small).boxed().collect(Collectors.toSet());
            int[] res = new int[]{};
            int ct = cnt.size();
            for (int l = 0, r = 0; r < big.length; r++) {
                if (!hash.contains(big[r])) continue;
                cnt.merge(big[r], -1, Integer::sum);
                if (cnt.get(big[r]) == 0) ct--;
                while (ct == 0) {
                    if (res.length == 0 || res[1] - res[0] > r - l) res = new int[]{l, r};
                    if (hash.contains(big[l])) {
                        cnt.merge(big[l], 1, Integer::sum);
                        if (cnt.get(big[l]) == 1) ct++;
                    }
                    l++;
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}