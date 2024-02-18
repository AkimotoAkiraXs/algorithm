// Given the root of an n-ary tree, return the preorder traversal of its nodes' 
// values. 
//
// Nary-Tree input serialization is represented in their level order traversal. 
// Each group of children is separated by the null value (See examples) 
//
// 
// Example 1: 
//
// 
//
// 
// Input: root = [1,null,3,2,4,null,5,6]
// Output: [1,3,5,6,2,4]
// 
//
// Example 2: 
//
// 
//
// 
// Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,
// null,12,null,13,null,null,14]
// Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// 0 <= Node.val <= 10⁴ 
// The height of the n-ary tree is less than or equal to 1000. 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
//
// 👍 396 👎 0

package problems.leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import model.Node;

/**
 * Id：&emsp;&emsp;589
 * <p>
 * Name：N-ary Tree Preorder Traversal
 *
 * @author Yuri
 * @since 2024-02-18 10:13:54
 */

public class NAryTreePreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();

    }
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public List<Integer> preorder(Node root) {
            if (root == null) return Collections.emptyList();
            List<Integer> res = new LinkedList<>();
            res.add(root.val);
            for (Node node : root.children)
                res.addAll(preorder(node));
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}