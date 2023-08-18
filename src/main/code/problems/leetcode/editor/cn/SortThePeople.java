// You are given an array of strings names, and an array heights that consists
// of distinct positive integers. Both arrays are of length n.
//
// For each index i, names[i] and heights[i] denote the name and height of the 
// iᵗʰ person.
//
// Return names sorted in descending order by the people's heights. 
//
// 
// Example 1: 
//
// 
// Input: names = ["Mary","John","Emma"], heights = [180,165,170]
// Output: ["Mary","Emma","John"]
// Explanation: Mary is the tallest, followed by Emma and John.
// 
//
// Example 2: 
//
// 
// Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
// Output: ["Bob","Alice","Bob"]
// Explanation: The first Bob is the tallest, followed by Alice and the second
// Bob.
// 
//
// 
// Constraints: 
//
// 
// n == names.length == heights.length 
// 1 <= n <= 10³ 
// 1 <= names[i].length <= 20 
// 1 <= heights[i] <= 10⁵ 
// names[i] consists of lower and upper case English letters. 
// All the values of heights are distinct. 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 56 👎 0

package problems.leetcode.editor.cn;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Id：&emsp;&emsp;2418
 * <p>
 * Name：Sort the People
 *
 * @author Yuri
 * @since 2023-04-25 16:08:30
 */


public class SortThePeople {
    public static void main(String[] args) {
        Solution solution = new SortThePeople().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            Map<Integer, String> map = new TreeMap<>(Comparator.comparingInt(Integer::intValue).reversed());
            for (int i = 0; i < names.length; i++) map.put(heights[i], names[i]);
            return map.values().toArray(new String[0]);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
