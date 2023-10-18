// You are given the head of a singly linked-list. The list can be represented
// as:
//
// 
// L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
// be changed.
//
// 
// Example 1: 
// 
// 
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// 
//
// Example 2: 
// 
// 
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 10⁴]. 
// 1 <= Node.val <= 1000 
// 
//
// 👍 1384 👎 0

package problems.leetcode.editor.cn;

import model.ListNode;

/**
 * Id：&emsp;&emsp;143
 * <p>
 * Name：Reorder List
 *
 * @author Yuri
 * @since 2023-10-18 17:02:44
 */

public class ReorderList {

    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        solution.reorderList(new ListNode(1, 2, 3, 4, 5));
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

        /**
         * @see MiddleOfTheLinkedList Lc876链表的中间结点
         * @see ReverseLinkedList Lc206链表反转
         */
        public void reorderList(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode node2 = reverse(mid);
            while (node2.next != null) {
                ListNode next = head.next;
                ListNode next2 = node2.next;
                head.next = node2;
                head = next;
                node2.next = head;
                node2 = next2;
            }
        }

        // 获取链表中间节点
        private ListNode middleNode(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        // 反转链表
        private ListNode reverse(ListNode head) {
            ListNode pre = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}