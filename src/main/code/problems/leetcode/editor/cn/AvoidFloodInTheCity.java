// Your country has an infinite number of lakes. Initially, all the lakes are
// empty, but when it rains over the nth lake, the nth lake becomes full of water. If
// it rains over a lake that is full of water, there will be a flood. Your goal is
// to avoid floods in any lake.
//
// Given an integer array rains where: 
//
// 
// rains[i] > 0 means there will be rains over the rains[i] lake. 
// rains[i] == 0 means there are no rains this day and you can choose one lake 
// this day and dry it.
// 
//
// Return an array ans where: 
//
// 
// ans.length == rains.length 
// ans[i] == -1 if rains[i] > 0. 
// ans[i] is the lake you choose to dry in the ith day if rains[i] == 0. 
// 
//
// If there are multiple valid answers return any of them. If it is impossible 
// to avoid flood return an empty array.
//
// Notice that if you chose to dry a full lake, it becomes empty, but if you 
// chose to dry an empty lake, nothing changes.
//
// 
// Example 1: 
//
// 
// Input: rains = [1,2,3,4]
// Output: [-1,-1,-1,-1]
// Explanation: After the first day full lakes are [1]
// After the second day full lakes are [1,2]
// After the third day full lakes are [1,2,3]
// After the fourth day full lakes are [1,2,3,4]
// There's no day to dry any lake and there is no flood in any lake.
// 
//
// Example 2: 
//
// 
// Input: rains = [1,2,0,0,2,1]
// Output: [-1,-1,2,1,-1,-1]
// Explanation: After the first day full lakes are [1]
// After the second day full lakes are [1,2]
// After the third day, we dry lake 2. Full lakes are [1]
// After the fourth day, we dry lake 1. There is no full lakes.
// After the fifth day, full lakes are [2].
// After the sixth day, full lakes are [1,2].
// It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another
// acceptable scenario.
// 
//
// Example 3: 
//
// 
// Input: rains = [1,2,0,1,2]
// Output: []
// Explanation: After the second day, full lakes are  [1,2]. We have to dry one
// lake in the third day.
// After that, it will rain over lakes [1,2]. It's easy to prove that no matter
// which lake you choose to dry in the 3rd day, the other one will flood.
// 
//
// 
// Constraints: 
//
// 
// 1 <= rains.length <= 10⁵ 
// 0 <= rains[i] <= 10⁹ 
// 
//
// 👍 180 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Id：&emsp;&emsp;1488
 * <p>
 * Name：Avoid Flood in The City
 *
 * @author Yuri
 * @since 2023-10-13 14:50:30
 */

public class AvoidFloodInTheCity {

    public static void main(String[] args) {
        Solution solution = new AvoidFloodInTheCity().new Solution();
        int[] ints = solution.avoidFlood(new int[]{1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3});
        System.out.println(Arrays.toString(ints));
    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 贪心 + 二分：把没下雨的天记录下来，遇到一个湖重复下雨天找上一次下雨天的下一个未下雨天抽该湖的水
         */
        public int[] avoidFlood(int[] rains) {
            int n = rains.length;
            TreeSet<Integer> free = new TreeSet<>(); // 用Tree就不用自己写二分了
            Map<Integer, Integer> map = new HashMap<>();
            int[] res = new int[n];
            Arrays.fill(res, 1); // 因为题目说没下雨可以随便选一天抽，没说不能抽，所以没下雨又不用抽的天需要赋值1
            for (int i = 0; i < n; i++) {
                if (rains[i] == 0) free.add(i);
                else {
                    if (map.containsKey(rains[i])) {
                        Integer index = free.ceiling(map.get(rains[i]));
                        if (index == null) return new int[]{};
                        res[index] = rains[i];
                        free.remove(index); // 删除已经用了的天
                    }
                    res[i] = -1;
                    map.put(rains[i], i);
                }
            }
            return res;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}