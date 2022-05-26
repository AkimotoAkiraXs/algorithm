package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2021/10/27 14:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int[] nums) {
        this(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public ListNode(List<Integer> nums) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("error argument!");
        }
        this.val = nums.remove(0);
        this.next = nums.isEmpty() ? null : new ListNode(nums);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1});
        System.out.println(listNode);
    }
}
