//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 755 👎 0


package leetcode.editor.cn;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Id：&emsp;&emsp;572
 * <p>
 * Name：另一棵树的子树
 *
 * @author Yuri
 * @since 2022-06-23 11:46:23
 */
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        TreeNode treeNode = new TreeNode(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
        TreeNode treeNode1 = new TreeNode(new Integer[]{4,1,2});
        boolean subtree = solution.isSubtree(treeNode, treeNode1);
        System.out.println(subtree);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

/*
    //暴力
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            return root != null && (equal(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
        }

        boolean equal(TreeNode a, TreeNode b) {
            return ((a == null & b == null) ||
                    (a != null && b != null && Objects.equals(a.val, b.val) && equal(a.left, b.left) && equal(a.right, b.right)));
        }
    }
    */

    //KMP
    class Solution {
        //用List而非String避免出现12 1这种误判情况
        private List<String> str = new ArrayList<>();
        private List<String> match = new ArrayList<>();
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            preOrder(root, str);
            preOrder(subRoot, match);
            return kmp();
        }

        //先序遍历对于单子树而言得到的遍历是真正的子树序列
        //换句话说，先序遍历可以把找子树问题转换为找子串问题
        private void preOrder(TreeNode node, List<String> res) {
            if (node == null) {
                res.add(null);//插入空值，保证判断出子树的正确性
                return;
            }
            res.add(String.valueOf(node.val));
            preOrder(node.left, res);
            preOrder(node.right, res);
        }

        private boolean kmp() {
            int[] next = getNext(str);
            int k = -1;
            for (String s : str) {
                while (k > -1 && !Objects.equals(s, match.get(k + 1))) {
                    k = next[k];
                }
                if (Objects.equals(s, match.get(k + 1))) {
                    k++;
                }
                if (k == match.size() - 1) {
                    return true;
                }
            }
            return false;
        }

        private int[] getNext(List<String> str) {
            int[] next = new int[str.size()];
            next[0] = -1;
            int k = -1;
            for (int i = 1; i < str.size(); i++) {
                while (k > -1 && !Objects.equals(str.get(k + 1), str.get(i))) {
                    k = next[k];
                }
                if (Objects.equals(str.get(k + 1), str.get(i))) {
                    k++;
                }
                next[i] = k;
            }
            return next;
        }
    }


    //todo method3 树哈希
//leetcode submit region end(Prohibit modification and deletion)

}