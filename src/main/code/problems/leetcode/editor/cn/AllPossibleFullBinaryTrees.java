//Given an integer n, return a list of all possible full binary trees with n 
//nodes. Each node of each tree in the answer must have Node.val == 0. 
//
// Each element of the answer is the root node of one possible tree. You may 
//return the final list of trees in any order. 
//
// A full binary tree is a binary tree where each node has exactly 0 or 2 
//children. 
//
// 
// Example 1: 
// 
// 
//Input: n = 7
//Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,
//0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: [[0,0,0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
//
// 👍 378 👎 0

package problems.leetcode.editor.cn;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;894
 * <p>
 * Name：All Possible Full Binary Trees
 *
 * @author Yuri
 * @since 2024-04-02 16:50:20
 */

public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees().new Solution();
        solution.allPossibleFBT(7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution_dfs {
        // dfs, 这题主要还是考察dfs递归的运用
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> result = new ArrayList<>();
            if (n == 1) result.add(new TreeNode(0));
            for (int i = 1; i < n; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(n - i - 1);
                for (TreeNode l : left)
                    for (TreeNode r : right)
                        result.add(new TreeNode(0, l, r));
            }
            return result;
        }
    }

    // Dp
    @SuppressWarnings("unchecked")
    class Solution {
        private final static List<TreeNode>[] f = new List[20];

        static {

            f[1] = Stream.of(new TreeNode(0)).collect(Collectors.toList());
            for (int i = 3; i < 20; i += 2) {
                f[i] = new ArrayList<>();
                for (int j = 1; j < i; j += 2) {
                    for (TreeNode left : f[j])
                        for (TreeNode right : f[i - j - 1])
                            f[i].add(new TreeNode(0, left, right));
                }
            }
        }

        public List<TreeNode> allPossibleFBT(int n) {
            return (n & 1) == 0 ? new ArrayList<>() : f[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}