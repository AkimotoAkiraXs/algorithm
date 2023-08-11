package nowcoder.hj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yuri
 * @since 2023/4/6 14:54
 */
public class Hj93 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> nums = new LinkedList<>();
        in.nextLine();
        AtomicInteger a = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();
        Arrays.stream(in.nextLine().split(" ")).forEach(o -> {
            int num = Integer.parseInt(o);
            if (num % 5 == 0) a.addAndGet(num);
            else if (num % 3 == 0) b.addAndGet(num);
            else nums.add(num);
        });
        System.out.println(recur(a.get() - b.get(), 0, nums, 0));
    }

    public static boolean recur(int gap, int num, List<Integer> nums, int i) {
        if (i == nums.size()) return gap == num || gap == -num;
        Integer k = nums.get(i);
        return recur(gap, num + k, nums, i + 1) || recur(gap, num - k, nums, i + 1);
    }
}
