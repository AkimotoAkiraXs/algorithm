package problems.leetcode.editor.cn;

import model.ListNode;

/**
 * Id：&emsp;&emsp;2 <br/>
 * Name：Add Two Numbers <br/>
 * @see AddTwoNumbersIi Lc445 两数相加II
 *
 * @author Yuri
 * @since 2023-07-03 22:30:00
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        System.out.println();
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode root = new ListNode(), node = new ListNode();
            boolean first = true;
            while (l1 != null || l2 != null) {
                int a = 0, b = 0;
                if (l1 != null) {
                    a = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    b = l2.val;
                    l2 = l2.next;
                }
                var val = (carry + a + b) % 10;
                carry = (carry + a + b) / 10;
                if (first) {
                    first = false;
                    root = new ListNode(val);
                    node = root;
                }else {
                    node.next = new ListNode(val);
                    node = node.next;
                }
            }
            if (carry == 1) node.next = new ListNode(1);
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
