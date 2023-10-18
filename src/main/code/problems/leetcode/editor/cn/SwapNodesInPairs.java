// Given a linked list, swap every two adjacent nodes and return its head. You
// must solve the problem without modifying the values in the list's nodes (i.e.,
// only nodes themselves may be changed.)
//
// 
// Example 1: 
// 
// 
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
// Input: head = []
// Output: []
// 
//
// Example 3: 
//
// 
// Input: head = [1]
// Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
//
// 👍 2058 👎 0

package problems.leetcode.editor.cn;

import model.ListNode;

/**
 * Id：&emsp;&emsp;24
 * <p>
 * Name：Swap Nodes in Pairs
 *
 * @author Yuri
 * @since 2023-10-17 18:11:15
 */

public class SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        solution.swapPairs(new ListNode(new int[]{1, 2, 3, 4}));
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

        public ListNode swapPairs(ListNode head) {
            // dummy是起始哨兵，pre是每次翻转前哨兵
            ListNode dummy = new ListNode(0, head);

            ListNode pre = dummy, cur = head;
            while (cur != null && cur.next != null) {
                pre.next = cur.next;
                ListNode next = cur.next.next;
                cur.next.next = cur;
                cur.next = next;
                pre = cur;
                cur = next;
            }
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}