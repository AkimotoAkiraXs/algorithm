package nowcoder.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hj80 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) nums.add(in.nextInt());
        }
        StringBuilder sb = nums.stream().distinct().sorted().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(sb);
    }

}
