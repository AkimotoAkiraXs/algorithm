// You are given an array of k linked-lists lists, each linked-list is sorted in
// ascending order.
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
// Input: lists = []
// Output: []
// 
//
// Example 3: 
//
// 
// Input: lists = [[]]
// Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
//
// 👍 2671 👎 0

package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import model.ListNode;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Id：&emsp;&emsp;23
 * <p>
 * Name：Merge k Sorted Lists
 *
 * @author Yuri
 * @since 2023-10-20 10:13:25
 */

public class MergeKSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();

        solution.mergeKLists(new ListNode[]{new ListNode(1, 4, 5), new ListNode(1, 3, 4), new ListNode(2, 6)});
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

        // 分治法
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            return mergeKLists(lists, 0, lists.length - 1);
        }

        public ListNode mergeKLists(ListNode[] lists, int s, int e) {
            if (e == s) return lists[s];
            return mergeTwoLists(mergeKLists(lists, s, (s + e) / 2), mergeKLists(lists, (s + e) / 2 + 1, e));
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 != null || l2 != null) {
                if (l1 == null || (l2 != null && l2.val < l1.val)) {
                    l2.next = mergeTwoLists(l1, l2.next);
                    return l2;
                }
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            return null;
        }

        // 最小堆，放节点nlogk，k为链表长度
        public ListNode mergeKLists__(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode node : lists) {
                if (node != null) queue.offer(node);
            }
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if (node.next != null) queue.offer(node.next);
            }
            return dummy.next;
        }

        // 最小堆，放所有数nlogn
        public ListNode mergeKLists_(ListNode[] lists) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (ListNode node : lists) {
                while (node != null) {
                    queue.add(node.val);
                    node = node.next;
                }
            }
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (!queue.isEmpty()) {
                cur.next = new ListNode(queue.poll());
                cur = cur.next;
            }
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}