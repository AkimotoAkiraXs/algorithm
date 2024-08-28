// You are the owner of a company that creates alloys using various types of
// metals. There are n different types of metals available, and you have access to k
// machines that can be used to create alloys. Each machine requires a specific
// amount of each metal type to create an alloy.
//
// For the iᵗʰ machine to create an alloy, it needs composition[i][j] units of 
// metal of type j. Initially, you have stock[i] units of metal type i, and
// purchasing one unit of metal type i costs cost[i] coins.
//
// Given integers n, k, budget, a 1-indexed 2D array composition, and 1-indexed 
// arrays stock and cost, your goal is to maximize the number of alloys the
// company can create while staying within the budget of budget coins.
//
// All alloys must be created with the same machine. 
//
// Return the maximum number of alloys that the company can create. 
//
// 
// Example 1: 
//
// 
// Input: n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0
//,0,0], cost = [1,2,3]
// Output: 2
// Explanation: It is optimal to use the 1ˢᵗ machine to create alloys.
// To create 2 alloys we need to buy the:
//- 2 units of metal of the 1ˢᵗ type.
//- 2 units of metal of the 2ⁿᵈ type.
//- 2 units of metal of the 3ʳᵈ type.
// In total, we need 2 * 1 + 2 * 2 + 2 * 3 = 12 coins, which is smaller than or
// equal to budget = 15.
// Notice that we have 0 units of metal of each type and we have to buy all the
// required units of metal.
// It can be proven that we can create at most 2 alloys.
// 
//
// Example 2: 
//
// 
// Input: n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0
//,0,100], cost = [1,2,3]
// Output: 5
// Explanation: It is optimal to use the 2ⁿᵈ machine to create alloys.
// To create 5 alloys we need to buy:
//- 5 units of metal of the 1ˢᵗ type.
//- 5 units of metal of the 2ⁿᵈ type.
//- 0 units of metal of the 3ʳᵈ type.
// In total, we need 5 * 1 + 5 * 2 + 0 * 3 = 15 coins, which is smaller than or
// equal to budget = 15.
// It can be proven that we can create at most 5 alloys.
// 
//
// Example 3: 
//
// 
// Input: n = 2, k = 3, budget = 10, composition = [[2,1],[1,2],[1,1]], stock = [
// 1,1], cost = [5,5]
// Output: 2
// Explanation: It is optimal to use the 3ʳᵈ machine to create alloys.
// To create 2 alloys we need to buy the:
//- 1 unit of metal of the 1ˢᵗ type.
//- 1 unit of metal of the 2ⁿᵈ type.
// In total, we need 1 * 5 + 1 * 5 = 10 coins, which is smaller than or equal to
// budget = 10.
// It can be proven that we can create at most 2 alloys.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n, k <= 100 
// 0 <= budget <= 10⁸ 
// composition.length == k 
// composition[i].length == n 
// 1 <= composition[i][j] <= 100 
// stock.length == cost.length == n 
// 0 <= stock[i] <= 10⁸ 
// 1 <= cost[i] <= 100 
// 
//
// 👍 78 👎 0

package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;2861
 * <p>
 * Name：Maximum Number of Alloys
 *
 * @author Yuri
 * @since 2024-08-28 15:51:16
 */

public class MaximumNumberOfAlloys {

    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfAlloys().new Solution();
        System.out.println(solution.maxNumberOfAlloys(3, 2, 15,
            Stream.of(Lists.newArrayList(1, 1, 1), Lists.newArrayList(1, 1, 10)).collect(Collectors.toList())
            , Lists.newArrayList(0, 0, 0), Lists.newArrayList(1, 2, 3)));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock,
            List<Integer> cost) {
            int l = 0, r = budget + stock.stream().max(Comparator.comparingInt(i -> i)).get();
            while (l <= r) {
                int m = l + r >> 1;
                long min = Long.MAX_VALUE;
                for (var com : composition) {
                    long sum = 0;
                    for (int i = 0; i < n; i++) {
                        long tot = (long) com.get(i) * m;
                        sum += Math.max(0, tot - stock.get(i)) * cost.get(i);
                    }
                    min = Math.min(min, sum);
                }
                if (min <= budget) l = m + 1;
                else r = m - 1;
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}