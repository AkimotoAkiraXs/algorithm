// There are two mice and n different types of cheese, each type of cheese
// should be eaten by exactly one mouse.
//
// A point of the cheese with index i (0-indexed) is: 
//
// 
// reward1[i] if the first mouse eats it. 
// reward2[i] if the second mouse eats it. 
// 
//
// You are given a positive integer array reward1, a positive integer array 
// reward2, and a non-negative integer k.
//
// Return the maximum points the mice can achieve if the first mouse eats 
// exactly k types of cheese.
//
// 
// Example 1: 
//
// 
// Input: reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
// Output: 15
// Explanation: In this example, the first mouse eats the 2ⁿᵈ (0-indexed) and
// the 3ʳᵈ types of cheese, and the second mouse eats the 0ᵗʰ and the 1ˢᵗ types of
// cheese.
// The total points are 4 + 4 + 3 + 4 = 15.
// It can be proven that 15 is the maximum total points that the mice can
// achieve.
// 
//
// Example 2: 
//
// 
// Input: reward1 = [1,1], reward2 = [1,1], k = 2
// Output: 2
// Explanation: In this example, the first mouse eats the 0ᵗʰ (0-indexed) and 1ˢᵗ
// types of cheese, and the second mouse does not eat any cheese.
// The total points are 1 + 1 = 2.
// It can be proven that 2 is the maximum total points that the mice can achieve.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= n == reward1.length == reward2.length <= 10⁵ 
// 1 <= reward1[i], reward2[i] <= 1000 
// 0 <= k <= n 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 30 👎 0

package leetcode.editor.cn;

import cn.hutool.core.lang.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;2611
 * <p>
 * Name：Mice and Cheese
 *
 * @author Yuri
 * @since 2023-06-07 10:07:41
 */


public class MiceAndCheese {
    public static void main(String[] args) {
        Solution solution = new MiceAndCheese().new Solution();
        solution.miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int ans = 0;
            int n = reward1.length;
            int[] diffs = new int[n];
            for (int i = 0; i < n; i++) {
                ans += reward2[i];
                diffs[i] = reward1[i] - reward2[i];
            }
            Arrays.sort(diffs);
            for (int i = 1; i <= k; i++) ans += diffs[n - i];
            return ans;
        }

        // Pair+Java8
        public int miceAndCheesePair(int[] reward1, int[] reward2, int k) {
            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            int n = reward1.length;
            for (int i = 0; i < n; i++) pairs.add(new Pair<>(reward1[i], reward2[i]));
            pairs = pairs.stream().sorted(Comparator.comparingInt((Pair<Integer, Integer> o) -> (o.getKey() - o.getValue())).reversed()).collect(Collectors.toList());
            int score = 0;
            for (int i = 0; i < n; i++) {
                if (k > 0) {
                    score += pairs.get(i).getKey();
                    k--;
                } else score += pairs.get(i).getValue();
            }
            return score;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
