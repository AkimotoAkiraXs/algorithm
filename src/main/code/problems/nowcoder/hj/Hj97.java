package problems.nowcoder.hj;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yuri
 * @since 2023/4/6 16:47
 */
public class Hj97 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        AtomicInteger cnt = new AtomicInteger();
        AtomicInteger pos = new AtomicInteger();
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).forEach(o -> {
            if (o < 0) cnt.getAndIncrement();
            if (o > 0) {
                pos.getAndIncrement();
                sum.addAndGet(o);
            }
        });
        System.out.printf("%d ", cnt.get());
        if (pos.get() == 0) {
            System.out.println("0.0");
        }else {
            DecimalFormat format = new DecimalFormat("0.0");
            System.out.println(format.format((double) sum.get() / pos.get()));
        }
    }
}
