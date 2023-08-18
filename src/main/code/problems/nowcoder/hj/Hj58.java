package problems.nowcoder.hj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/3/13 11:27
 */

public class Hj58 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        List<Integer> nums = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        for (int i = 0; i < k; i++) System.out.printf("%s ", nums.get(i));
    }

}
