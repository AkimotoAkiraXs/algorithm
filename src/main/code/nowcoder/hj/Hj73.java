package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/28 22:23
 */

public class Hj73 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        int res = 0;
        boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        if (month > 2 && leap) res++;
        while (--month > 0) {
            if (month == 2) res += 28;
            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                res += 31;
            }
            else res += 30;
        }
        res += day;
        System.out.println(res);
    }
}
