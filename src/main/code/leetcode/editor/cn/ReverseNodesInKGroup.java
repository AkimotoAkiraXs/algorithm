package leetcode.editor.cn;

import com.google.common.collect.Lists;
import model.ListNode;

/**
 * Id：&emsp;&emsp;25
 * <p>
 * Name：K 个一组翻转链表
 * </p>
 * 链表处理、链表翻转，题目要求实现空间复杂度O(1)所以不用提出数据翻转再重新组装链表的方法
 *
 * @author Yuri
 * @since 2023-02-22 12:31:34
 */

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode head = new ListNode(Lists.newArrayList(2, 1, 4, 3, 5));
        System.out.println(head);

        solution.reverseKGroup(head, 2);

        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)

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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode node = head;
            int num = 0;
            while (node != null) {
                num++;
                node = node.next;
            }

            ListNode dum = new ListNode(0);
            dum.next = head;
            ListNode pre = dum;
            ListNode cur = head;
            ListNode next;
            // 处理链表过程中最好不要形成环（就算是后面会断环），如果想不明白最后画图一步一步去看链表的重新装卸过程
            for (int i = 0; i < num / k; i++) {
                for (int j = 1; j < k; j++) {
                    next = cur.next;
                    cur.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                }
                pre = cur;
                cur = pre.next;
            }
            return dum.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
