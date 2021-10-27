package pojo;

/**
 * @Author Yuri
 * @Date 2021/10/27 14:00
 * @Version 1.0
 * @Description:
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode child = null;

        System.out.println(child);
    }
}
