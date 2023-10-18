// Given the head of a linked list, return the node where the cycle begins. If
// there is no cycle, return null.
//
// There is a cycle in a linked list if there is some node in the list that can 
// be reached again by continuously following the next pointer. Internally, pos is
// used to denote the index of the node that tail's next pointer is connected to (0
//-indexed). It is -1 if there is no cycle. Note that pos is not passed as a 
// parameter.
//
// Do not modify the linked list. 
//
// 
// Example 1: 
// 
// 
// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the
// second node.
// 
//
// Example 2: 
// 
// 
// Input: head = [1,2], pos = 0
// Output: tail connects to node index 0
// Explanation: There is a cycle in the linked list, where tail connects to the
// first node.
// 
//
// Example 3: 
// 
// 
// Input: head = [1], pos = -1
// Output: no cycle
// Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
//
// 👍 2364 👎 0

package problems.leetcode.editor.cn;

import model.ListNode;

/**
 * Id：&emsp;&emsp;142
 * <p>
 * Name：Linked List Cycle II
 *
 * @author Yuri
 * @since 2023-10-18 15:58:25
 */

public class LinkedListCycleIi {

    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();

        ListNode node = new ListNode(1, null);
        node.next = node;
        solution.detectCycle(node);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {

        /**
         * 为什么在fast、slow相遇后，slow和head同时移动相遇时一定在环起点？
         * <p>
         * 数学推导：设head到环起点步数为n，slow进入环后走k步与fast相遇，环长m。
         * 从慢指针进环开始，快指针已在环内走过n步，可以推导得：s%m = (2s+n)%m，即(s+n)/m == 0，所以慢指针再走n步就会到达环起点。
         */
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    // 此处可用数学推导
                    while (head != slow) {
                        slow = slow.next;
                        head = head.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}