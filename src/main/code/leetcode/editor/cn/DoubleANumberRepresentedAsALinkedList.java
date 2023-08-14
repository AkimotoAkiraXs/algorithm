package leetcode.editor.cn;

import model.ListNode;

/**
 * Id：&emsp;&emsp;2816 <br/>
 * Name：Double a Number Represented as a Linked List <br/>
 *
 * @author Yuri
 * @since 2023-08-14 21:55:14
 */

public class DoubleANumberRepresentedAsALinkedList {
    public static void main(String[] args) {
        Solution solution = new DoubleANumberRepresentedAsALinkedList().new Solution();
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
        public ListNode doubleIt(ListNode head) {

            ListNode node = head;
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append(node.val);
                node = node.next;
            }
            String val = sb.toString();
            String multiply = multiply(val, "2");

            ListNode last = null;
            ListNode cur = new ListNode();
            for (int i = multiply.length() - 1; i >= 0; i--) {
                cur = new ListNode(multiply.charAt(i) - '0', last);
                last = cur;
            }
            return cur;
        }

        public String multiply(String num1, String num2) {
            String n1 = new StringBuilder(num1).reverse().toString();
            String n2 = new StringBuilder(num2).reverse().toString();
            int[] d = new int[num1.length() + num2.length()];

            for (int i = 0; i < n1.length(); i++)
                for (int j = 0; j < n2.length(); j++)
                    d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < d.length; i++) {
                int mod = d[i] % 10;
                int carry = d[i] / 10;
                if (i + 1 < d.length)
                    d[i + 1] += carry;
                sb.insert(0, mod);
            }
            while (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
