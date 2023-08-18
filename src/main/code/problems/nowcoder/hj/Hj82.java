package problems.nowcoder.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hj82 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] nums = s.split("/");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int n = a, num = a;
            List<String> res = new ArrayList<>();
            while (n > 1) {
                if (n % b == 0) {
                    res.add("1/" + n/b);
                    num -= n;
                    n = num;
                }else {
                    n--;
                }
            }
            for (int i = 0; i < num; i++) {
                res.add("1/" + b);
            }
            System.out.println(String.join("+", res));
        }
    }
}
