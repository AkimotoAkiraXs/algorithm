// Given the head of a singly linked list and two integers left and right where
// left <= right, reverse the nodes of the list from position left to position
// right, and return the reversed list.
//
// 
// Example 1: 
// 
// 
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
// Input: head = [5], left = 1, right = 1
// Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
// Follow up: Could you do it in one pass?
//
// 👍 1670 👎 0

package problems.leetcode.editor.cn;

import model.ListNode;

/**
 * Id：&emsp;&emsp;92
 * <p>
 * Name：Reverse Linked List II
 *
 * @author Yuri
 * @since 2023-10-17 15:01:20
 */

public class ReverseLinkedListIi {

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        solution.reverseBetween(new ListNode(new int[]{3, 5}), 1, 2);
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

        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode node = dummy;
            for (int i = 0; i < left - 1; i++) node = node.next;

            ListNode cur = node.next, pre = null;
            for (int i = left; i <= right; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            node.next.next = cur;
            node.next = pre;
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}