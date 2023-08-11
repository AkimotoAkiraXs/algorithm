package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/8 13:14
 */

public class Hj37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(func(n) + 1); // 1是最开始那只兔兔
    }

    // 这个函数求某个剩余n个月的兔兔能生多少孩子
    public static int func(int n) {
        int sum = 0;
        // 设i=2而不是3是因为兔兔三月后生孩也包含它出生的那个月
        for (int i = 2; i < n; i++) {
            sum += 1 + func(n - i); // sum += 子兔兔本身 + 接下来n个月生的孩子数
        }
        return sum;
    }
}
