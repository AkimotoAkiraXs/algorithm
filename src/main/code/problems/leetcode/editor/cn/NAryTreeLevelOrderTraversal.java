// Given an n-ary tree, return the level order traversal of its nodes' values.
//
// Nary-Tree input serialization is represented in their level order traversal, 
// each group of children is separated by the null value (See examples).
//
// 
// Example 1: 
//
// 
//
// 
// Input: root = [1,null,3,2,4,null,5,6]
// Output: [[1],[3,2,4],[5,6]]
// 
//
// Example 2: 
//
// 
//
// 
// Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,
// null,12,null,13,null,null,14]
// Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
// Constraints: 
//
// 
// The height of the n-ary tree is less than or equal to 1000 
// The total number of nodes is between [0, 10⁴] 
// 
//
// 👍 450 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Node;

/**
 * Id：&emsp;&emsp;429
 * <p>
 * Name：N-ary Tree Level Order Traversal
 *
 * @author Yuri
 * @since 2024-02-19 18:31:28
 */

public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        solution.levelOrder(null);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        Map<Integer, List<Integer>> map = new HashMap<>();

        public List<List<Integer>> levelOrder(Node root) {
            map.clear();
            dfs(root, 0);
            return map.values().stream().toList();
        }

        private void dfs(Node root, int floor) {
            if (root == null) return;
            map.merge(floor, new ArrayList<>(List.of(root.val)), (a, b) ->{
                a.addAll(b);
                return a;
            });
            for (Node node : root.children) dfs(node, floor + 1);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}