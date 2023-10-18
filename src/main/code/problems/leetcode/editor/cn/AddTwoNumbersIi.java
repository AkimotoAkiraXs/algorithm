// You are given two non-empty linked lists representing two non-negative
// integers. The most significant digit comes first and each of their nodes contains a
// single digit. Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the 
// number 0 itself.
//
// 
// Example 1: 
// 
// 
// Input: l1 = [7,2,4,3], l2 = [5,6,4]
// Output: [7,8,0,7]
// 
//
// Example 2: 
//
// 
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [8,0,7]
// 
//
// Example 3: 
//
// 
// Input: l1 = [0], l2 = [0]
// Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
// leading zeros.
// 
//
// 
// Follow up: Could you solve it without reversing the input lists? 
//
// 👍 652 👎 0

package problems.leetcode.editor.cn;

import model.ListNode;
import org.checkerframework.checker.units.qual.K;

/**
 * Id：&emsp;&emsp;445
 * <p>
 * Name：Add Two Numbers II
 *
 * @author Yuri
 * @see AddTwoNumbers 两数相加
 * @since 2023-07-03 19:27:24
 */


public class AddTwoNumbersIi {

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        solution.addTwoNumbers(new ListNode(new int[]{6, 4, 5, 0, 4, 4, 9, 4, 1}),
            new ListNode(new int[]{3, 8, 8, 0, 3, 0, 1, 4, 8}));
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
            ListNode r1 = reverse(l1);
            ListNode r2 = reverse(l2);
            ListNode dummy = new ListNode(-1, r1);
            int carry = 0;
            ListNode pre = dummy;
            while (r1 != null && r2 != null) {
                int k = (r1.val + r2.val + carry) / 10;
                r1.val = (r1.val + r2.val + carry) % 10;
                carry = k;
                pre = r1;
                r1 = r1.next;
                r2 = r2.next;
            }
            if (r1 == null) {
                pre.next = r2;
                r1 = r2;
            }
            while (carry != 0 && r1 != null) {
                carry = (r1.val + 1) / 10;
                r1.val = (r1.val + 1) % 10;
                pre = r1;
                r1 = r1.next;
            }
            if (carry != 0) pre.next = new ListNode(1, null);
            return reverse(dummy.next);
        }


        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode cur = reverse(head.next);
            ListNode next = head.next.next;
            head.next.next = head;
            head.next = next;
            return cur;
        }
    }

    class Solution_ {

        // 这题可以用栈压数，就可以按顺序处理，也可以翻转链表
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            while (l1 != null) {
                s1.append(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                s2.append(l2.val);
                l2 = l2.next;
            }
            String sum = add(s1.toString(), s2.toString());
            ListNode root = new ListNode(sum.charAt(0) - '0');
            ListNode node = root;
            for (int i = 1; i < sum.length(); i++) {
                node.next = new ListNode(sum.charAt(i) - '0');
                node = node.next;
            }
            return root;
        }

        private String add(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            int flag = 0;
            int max = Math.max(len1, len2);
            StringBuilder res = new StringBuilder();
            while (max-- > 0) {
                int a = len1 > 0 ? s1.charAt(--len1) - '0' : 0;
                int b = len2 > 0 ? s2.charAt(--len2) - '0' : 0;
                res.append((a + b + flag) % 10);
                flag = (a + b + flag) / 10;
            }
            if (flag == 1) res.append(1);
            return res.reverse().toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
