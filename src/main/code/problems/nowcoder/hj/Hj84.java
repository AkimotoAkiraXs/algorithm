package problems.nowcoder.hj;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Hj84 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        AtomicInteger cnt = new AtomicInteger();
        s.codePoints().forEach(o -> {
            if (o >= 'A' && o <= 'Z') cnt.getAndIncrement();
        });
        System.out.println(cnt);
    }

}
