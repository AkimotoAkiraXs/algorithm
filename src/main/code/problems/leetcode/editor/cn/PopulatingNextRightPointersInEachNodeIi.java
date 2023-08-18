//给定一个二叉树 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 441 👎 0


/*
 * Id：117
 * Name：填充每个节点的下一个右侧节点指针 II
 * Date：2021-09-01 15:28:15
 */
package problems.leetcode.editor.cn;

public class PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
        System.out.println("Hello world");
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {

//        //普通bfs
//        public Node connect(Node root) {
//            if (root == null) return null;
//            List<Node> nodes = new LinkedList<>();
//            nodes.add(root);
//            while (!nodes.isEmpty()) {
//                for (int i = 1; i < nodes.size(); i++) {
//                    nodes.get(i-1).next = nodes.get(i);
//                }
//                List<Node> list = new LinkedList<>();
//                for (Node node : nodes) {
//                    if (node.left != null) list.add(node.left);
//                    if (node.right != null) list.add(node.right);
//                }
//                nodes.clear();
//                nodes.addAll(list);
//            }
//            return root;
//        }

        //空间O(1)链表构造
        Node nextStart, pre;

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Node start = root;
            while (start != null) {
                pre = nextStart = null;
                for (Node node = start; node != null; node = node.next) {
                    if (node.left != null) {
                        change(node.left);
                    }
                    if (node.right != null) {
                        change(node.right);
                    }
                }
                start = nextStart;
            }
            return root;
        }

        public void change(Node node) {
            if (pre != null) {
                pre.next = node;
            }
            if (nextStart == null) {
                nextStart = node;
            }
            pre = node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 